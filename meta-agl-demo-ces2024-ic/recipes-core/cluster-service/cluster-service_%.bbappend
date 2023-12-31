FILESEXTRAPATHS:prepend := "${THISDIR}/cluster-service:"

DEPENDS:append = " alsa-lib"

SRCREV = "d67d8556b134e01525ef552abc1b78b958d7c233"
SRC_URI = " \
    git://github.com/agl-ic-eg/cluster-service.git;branch=ces2024;protocol=https \
    file://cluster-service.service \
    file://vxcan-activate.service \
    file://vxcan-activate.sh \
    "

SYSTEMD_SERVICE:${PN} += " vxcan-activate.service"

do_install:append() {
    install -m 0755 ${WORKDIR}/vxcan-activate.sh ${D}/usr/bin/vxcan-activate.sh
    install -m 0644 ${WORKDIR}/vxcan-activate.service ${D}${systemd_unitdir}/system/
}

RDEPENDS:${PN} += " \
    iproute2-ip \
    bash \
"
