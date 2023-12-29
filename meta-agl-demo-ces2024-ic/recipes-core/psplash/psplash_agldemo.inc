FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://psplash-colors.h \
    file://psplash-args.conf \
"

SPLASH_IMAGES = "file://psplash-poky-img.h;outsuffix=default"

do_configure:append () {
	cp -f ${WORKDIR}/psplash-colors.h ${S}
}

do_install:append () {
    # Install override
    install -d ${D}${systemd_system_unitdir}/psplash-start.service.d
    install -m 0644 ${WORKDIR}/psplash-args.conf ${D}${systemd_system_unitdir}/psplash-start.service.d/
}

FILES:${PN} += "${systemd_system_unitdir}"
