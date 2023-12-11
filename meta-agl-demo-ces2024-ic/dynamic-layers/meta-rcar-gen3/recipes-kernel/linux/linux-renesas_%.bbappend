FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://disable_rt_group.cfg \
    file://virtio_loopback.cfg \
"

AGL_KCONFIG_FRAGMENTS += "disable_rt_group.cfg virtio_loopback.cfg"
