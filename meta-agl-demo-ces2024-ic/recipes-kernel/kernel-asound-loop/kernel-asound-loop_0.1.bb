SUMMARY = "ALSA loopback load and configration"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "file://alsa-loopback.conf"

S = "${WORKDIR}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install:append () {
    install -d ${D}${sysconfdir}/modules-load.d
    echo "snd_aloop" > ${D}${sysconfdir}/modules-load.d/snd_aloop.conf

    install -Dm644 ${WORKDIR}/alsa-loopback.conf ${D}${sysconfdir}/modprobe.d/alsa-loopback.conf
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} += " \
    ${sysconfdir}/modules-load.d/* \
    ${sysconfdir}/modprobe.d/* \
"
