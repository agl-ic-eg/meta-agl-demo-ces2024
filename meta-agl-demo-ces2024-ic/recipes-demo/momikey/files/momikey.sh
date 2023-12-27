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

while sleep 1 ;do event_reader ;done | while read line; do
    unset key target_container
    [[ "$line" =~ \((KEY_.)\),\ value\ 1 ]] && key="${BASH_REMATCH[1]}"
    case "$key" in
        KEY_G)
            cmcontrol --change-active-guest-name=agl-flutter-ivi-demo
            cmcontrol --shutdown-guest-role=ivi
            ;;
        KEY_S)
            cmcontrol --change-active-guest-name=agl-flutter-ivi-demo-simple
            cmcontrol --shutdown-guest-role=ivi
            ;;
        KEY_D)
            cmcontrol --change-active-guest-name=agl-qt-ivi-demo
            cmcontrol --shutdown-guest-role=ivi
            ;;
        KEY_H)
            cmcontrol --change-active-guest-name=agl-html5-ivi-demo
            cmcontrol --shutdown-guest-role=ivi
            ;;
        KEY_A)
            cmcontrol --change-active-guest-name=agl-momi-ivi-demo
            cmcontrol --shutdown-guest-role=ivi
            ;;
        KEY_B)
            cmcontrol --change-active-guest-name=agl-momi-ivi-demo-res
            cmcontrol --shutdown-guest-role=ivi
            ;;
        KEY_C)
            cmcontrol --force-reboot-guest-role=ivi
            ;;
    esac
done
