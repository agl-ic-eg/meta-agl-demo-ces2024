IMAGE_INSTALL += " \
    alsa-conf-guest-cluster \
    alsa-utils-aplay alsa-utils \
    can-utils systemd-netif-config-can-guest \
"

IMAGE_INSTALL:remove = " \
    pipewire-ic-ipc \
"
