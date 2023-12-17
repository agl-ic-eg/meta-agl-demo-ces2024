SUMMARY = "The virtio loopback sound"
DESCRIPTION = "A packages group for virtio loopback sound."

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-virtio-loopback-sound \
    "
RDEPENDS:${PN} += " \
    kernel-module-virtio-sound-0 kernel-module-virtio-sound-1 \
    "
