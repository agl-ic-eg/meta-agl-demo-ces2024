DESCRIPTION = "symlink from /home/root/Music to /media/usb0."
SECTION = "Multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

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
