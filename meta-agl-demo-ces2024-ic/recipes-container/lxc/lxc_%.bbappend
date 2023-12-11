FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SYSTEMD_PACKAGES += "${PN}-monitord"
SYSTEMD_SERVICE:${PN}-monitord = "lxc-monitord.service"
SYSTEMD_AUTO_ENABLE:${PN}-monitord = "enable"

PACKAGES =+ "${PN}-monitord"
