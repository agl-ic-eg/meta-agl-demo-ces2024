FILESEXTRAPATHS:prepend := "${THISDIR}/pipewire:"

SRC_URI += "\
    file://pipewire.conf \
"

do_install:append() {
    install -Dm644 ${WORKDIR}/pipewire.conf ${D}${datadir}/pipewire/pipewire.conf
}
