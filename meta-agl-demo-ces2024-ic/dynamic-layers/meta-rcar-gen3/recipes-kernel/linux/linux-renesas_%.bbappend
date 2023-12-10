FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://disable_rt_group.cfg \
"

AGL_KCONFIG_FRAGMENTS += "disable_rt_group.cfg"
