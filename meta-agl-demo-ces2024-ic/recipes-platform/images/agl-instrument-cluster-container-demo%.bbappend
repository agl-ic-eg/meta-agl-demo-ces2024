IMAGE_INSTALL += " \
    e2fsprogs-e2fsck e2fsprogs-mke2fs \
    gdb glibc-thread-db \
    libasan libubsan liblsan libtsan \
    htop util-linux-taskset util-linux-chrt \
    libcgroup \
"

IMAGE_INSTALL += " \
    cm-config-agl-momi-ivi-demo-res \
"

IMAGE_INSTALL += " \
    pulseaudio-server pulseaudio-pa-info pulseaudio-misc \
    pulseaudio-module-alsa-sink pulseaudio-module-alsa-source \
    pulseaudio-module-native-protocol-unix pulseaudio-module-loopback \
    pulseaudio-module-null-sink pulseaudio-module-null-source \
    pulseaudio-module-* \
    kernel-asound-loop \
    ti-bt-firmware linux-firmware-wl18xx wlconf iw \
    busybox-udhcpc wpa-supplicant-passphrase wpa-supplicant-cli wpa-supplicant \
    can-utils systemd-netif-config-can-host \
"

IMAGE_INSTALL:remove = " \
    packagegroup-pipewire \
    pipewire-ic-ipc \
    wireplumber-config-agl \
"

IMAGE_FEATURES += " ssh-server-openssh"

OUT_OF_TREE_CONTAINER_IMAGES ??= " \
    agl-ivi-demo-platform \
    agl-ivi-demo-platform-flutter \
    agl-ivi-demo-platform-html5 \
    agl-ivi-demo-platform-flutter-simple \
"

OUT_OF_TREE_CONTAINER_CONFIGS ??= " \
    cm-config-agl-qt-ivi-demo \
    cm-config-agl-flutter-ivi-demo \
    cm-config-agl-html5-ivi-demo \
    cm-config-agl-flutter-ivi-demo-simple \
"

WKS_FILES:remove = " \
    ${@oe.utils.conditional('OUT_OF_TREE_CONTAINER_IMAGE_DEPLOY_DIR', '', 'agl-ic-container-noloader.wks ', 'agl-ic-container-noloader-demo.wks ', d)} \
"
WKS_FILES:prepend = " \
    ${@oe.utils.conditional('OUT_OF_TREE_CONTAINER_IMAGE_DEPLOY_DIR', '', 'agl-ic-container-noloader.wks ', 'agl-ic-container-noloader-demo-ext.wks ', d)} \
"
