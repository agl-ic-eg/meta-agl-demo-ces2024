SUMMARY = "ALSA configration"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "file://asound.conf"

S = "${WORKDIR}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install:append () {
    install -Dm644 ${WORKDIR}/asound.conf ${D}${sysconfdir}/asound.conf
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} += " \
    ${sysconfdir}/* \
"
