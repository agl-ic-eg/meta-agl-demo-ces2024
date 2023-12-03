SUMMARY = "Momi Calc."
DESCRIPTION = "\
    A part of momi demonstrator \
    "
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cd2d29a5949072700ad429722a31512a"

PV = "1.0.0+rev${SRCPV}"

SRCREV = "8091eb0270a25e9db030f144820875c537a191ad"
SRC_URI = " \
    git://github.com/agl-ic-eg/momcalc.git;branch=main;protocol=https \
    "
S = "${WORKDIR}/git"

inherit autotools

