IMAGE_INSTALL += " \
    alsa-conf-guest-cluster \
    tzdata \
"

IMAGE_INSTALL:remove = " \
    pipewire-ic-ipc \
"

IMAGE_LINGUAS = "en-us ja-jp"
