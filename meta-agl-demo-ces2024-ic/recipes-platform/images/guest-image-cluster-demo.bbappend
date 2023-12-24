IMAGE_INSTALL += " \
    alsa-conf-guest-cluster \
    alsa-utils-aplay alsa-utils \
"

IMAGE_INSTALL:remove = " \
    pipewire-ic-ipc \
"
