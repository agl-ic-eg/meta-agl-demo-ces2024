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
    virtio-loopback-driver \
"

IMAGE_INSTALL:remove = " \
    packagegroup-pipewire \
    pipewire-ic-ipc \
    wireplumber-config-agl \
"

IMAGE_FEATURES += " ssh-server-openssh"
