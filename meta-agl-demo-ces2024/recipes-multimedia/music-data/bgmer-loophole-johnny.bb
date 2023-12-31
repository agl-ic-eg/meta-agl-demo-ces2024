DESCRIPTION = "Loophole Johnny from BGMer."
HOMEPAGE = "https://bgmer.net/"
LICENSE = "CLOSED"
SECTION = "Multimedia"

include recipes-multimedia/music-data/mp3-music-data.inc

MP3_MUSIC_DATA_ARTWORK = "monaco-way.jpg"
MP3_MUSIC_DATA_TITLE = "Loophole Johnny"
MP3_MUSIC_DATA_AIRTIST = "BGMer"
MP3_MUSIC_DATA_ALBUM = "BGMer"

SRC_URI = " \
    https://bgmer.net/wp-content/uploads/2022/05/245_BPM128.mp3 \
"
SRC_URI[sha256sum] = "bae4aaf3aa177d1b4f1862a64ce7d0a7ea8464d3928840867a8f7e5d7fa1eeb6"

inherit allarch

S = "${WORKDIR}"

do_populate_lic[noexec] = "1"
do_compile[noexec] = "1"
do_install() {
    install -d ${D}/media/usb0
    install -m 644 ${S}/245_BPM128.mp3 ${D}/media/usb0/
    eyeD3 ${EYED3_OPTIONS} ${D}/media/usb0/245_BPM128.mp3
}

PACKAGES = "\
    ${PN} \
"

FILES:${PN} = " \
    /media/usb0/* \
"
