#!/bin/bash

known_key_devices=(
    /dev/input/by-id/usb-wch.cn_CH57x-event-kbd
    /dev/input/by-id/usb-1189_8890-if02-event-kbd
)

event_reader () {
    local device target_device
    # try to grub any kind of usb keyboard
    known_key_devices+=(/dev/input/by-id/usb-*-kbd)
    for device in "${known_key_devices[@]}"; do
        [ -e "$device" ] && target_device="$device" && break
    done
    [ -z "$target_device" ] && return
    evtest "$target_device"
}

switch_guest () {
    target_guest="$1"
    [ "$current_guest" = "$target_guest" ] && return 0
    cmcontrol --change-active-guest-name="$target_guest"
    cmcontrol --shutdown-guest-role=ivi
    current_guest="$target_guest"
}

while sleep 1 ;do event_reader ;done | while read line; do
    unset key_push key_release target_container
    [[ "$line" =~ \((KEY_.)\),\ value\ 1 ]] && key_push="${BASH_REMATCH[1]}"
    [[ "$line" =~ \((KEY_.)\),\ value\ 0 ]] && key_release="${BASH_REMATCH[1]}"
    case "$key_release" in
        KEY_G)
            switch_guest agl-flutter-ivi-demo
            ;;
        KEY_S)
            switch_guest agl-flutter-ivi-demo-simple
            ;;
        KEY_D)
            switch_guest agl-qt-ivi-demo
            ;;
        KEY_H)
            switch_guest agl-html5-ivi-demo
            ;;
        KEY_A)
            switch_guest agl-momi-ivi-demo
            ;;
        KEY_B)
            switch_guest agl-momi-ivi-demo-res
            ;;
        KEY_C)
            cmcontrol --force-reboot-guest-role=ivi
            ;;
        KEY_1)
            cansend vxcan1 '168#0000000000000000'
            ;;
        KEY_2)
            cansend vxcan1 '484#0000000000000000'
            ;;
        KEY_3)
            cansend vxcan1 '232#0000000000000000'
            ;;
    esac
    case "$key_push" in
        KEY_1)
            cansend vxcan1 '168#1000000000000000'
            ;;
        KEY_2)
            cansend vxcan1 '484#0008000000000000'
            ;;
        KEY_3)
            cansend vxcan1 '232#4000000000000000'
            ;;
    esac
done
