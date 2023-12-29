SUMMARY = "VXCAN device setup"
DESCRIPTION = "VXCAN device setup. The vxcan1 and vxcan0 use inter container \
               comunication between host and cluster."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI += " \
    file://vxcan-setup.sh \
    file://vxcan-setup.service \
"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "vxcan-setup.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install:append () {
    install -d ${D}/usr/bin
    install -m 0755 ${WORKDIR}/vxcan-setup.sh ${D}/usr/bin/vxcan-setup.sh
    
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/vxcan-setup.service ${D}${systemd_system_unitdir}
}

FILES:${PN} += " \
    /usr/bin/vxcan-setup.sh \
    ${systemd_system_unitdir} \
"

RDEPENDS:${PN} = " \
    iproute2-ip \
"
