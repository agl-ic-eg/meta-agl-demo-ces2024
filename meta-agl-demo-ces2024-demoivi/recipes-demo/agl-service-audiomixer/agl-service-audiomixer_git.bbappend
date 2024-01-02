FILESEXTRAPATHS:prepend := "${THISDIR}/agl-service-audiomixer:"

SRC_URI:append = " \
    file://0001-Change-default-volume-to-100.patch \
"
