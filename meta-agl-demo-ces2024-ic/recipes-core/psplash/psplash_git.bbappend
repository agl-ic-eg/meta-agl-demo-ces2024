FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
require ${@bb.utils.contains('AGL_FEATURES', 'agl-drm-lease', 'psplash_agldemo.inc', '', d)}
