SUMMARY = "VIRTIO CAN device driver"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = " \
    file://loopback_driver.h;endline=1;md5=7226e442a172bcf25807246d7ef1eba1 \
"

inherit module

SRC_URI = " \
    file://Kbuild \
    file://loopback_driver0.c \
    file://loopback_driver.h \
"

S = "${WORKDIR}"

MAKE_TARGETS = "-C ${STAGING_KERNEL_DIR} M=${WORKDIR}"
MODULES_INSTALL_TARGET = "-C ${STAGING_KERNEL_DIR} M=${WORKDIR} modules_install"

do_install:append () {
    install -d ${D}${sysconfdir}/modules-load.d
    echo "loopback_driver0.ko" > ${D}${sysconfdir}/modules-load.d/loopback_driver0.conf
}

FILES:${PN} += " \
    ${sysconfdir}/modules-load.d/* \
"
