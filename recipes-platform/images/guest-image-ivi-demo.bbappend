IMAGE_INSTALL += " \
    mominjection \
    libcgroup \
    gstreamer1.0 gstreamer1.0-libav gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta gstreamer1.0-plugins-bad-meta \
    gstreamer1.0-plugins-ugly-meta \
    ttf-vlgothic ttf-sazanami-gothic ttf-sazanami-mincho \
"

IMAGE_INSTALL:remove = " \
    wireplumber \
    packagegroup-pipewire-base \
    wireplumber-policy-config-agl \
    "

IMAGE_FEATURES += " ssh-server-openssh"

