SUMMARY = "CH57x keyboard based UI for container demo"
DESCRIPTION = "Container exchange user interface using CH57x keyboard. \
               This UI based on mock container manager for AGL CES2023 demo."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI += " \
    file://mominjection.sh \
    file://mominjection.service \
"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "mominjection.service"
SYSTEMD_AUTO_ENABLE:${PN} = "disable"

do_install:append () {
    install -d ${D}/usr/bin
    install -m 0755 ${WORKDIR}/mominjection.sh ${D}/usr/bin/mominjection.sh
    
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/mominjection.service ${D}${systemd_system_unitdir}
}

FILES:${PN} += " \
    /usr/bin/mominjection.sh \
    ${systemd_system_unitdir} \
"

RDEPENDS:${PN} := " \
    bash \
    util-linux-chrt \
"
