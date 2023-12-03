FILESEXTRAPATHS:prepend := "${THISDIR}/lighttpd:"

SRC_URI:append = " \
    file://lighttpd.service \
    "
do_install:append() {
	install -m 0644 ${WORKDIR}/lighttpd.service ${D}${systemd_system_unitdir}
}
