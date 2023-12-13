DESCRIPTION = "symlink from /home/root/Music to /media/usb0."
LICENSE = "MIT"
SECTION = "Multimedia"

inherit allarch

do_populate_lic[noexec] = "1"
do_compile[noexec] = "1"
do_install() {
    install -d ${D}/home/root
    ln -s /media/usb0 ${D}/home/root/Music 
}

PACKAGES = "\
    ${PN} \
"

FILES:${PN} = " \
    /home/root/* \
"
