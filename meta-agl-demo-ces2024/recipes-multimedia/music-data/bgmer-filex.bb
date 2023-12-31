DESCRIPTION = "File X from BGMer."
HOMEPAGE = "https://bgmer.net/"
LICENSE = "CLOSED"
SECTION = "Multimedia"

include recipes-multimedia/music-data/mp3-music-data.inc

MP3_MUSIC_DATA_ARTWORK = "berlin-night.jpg"
MP3_MUSIC_DATA_TITLE = "File X"
MP3_MUSIC_DATA_AIRTIST = "BGMer"
MP3_MUSIC_DATA_ALBUM = "BGMer"

SRC_URI = " \
    https://bgmer.net/wp-content/uploads/2021/10/143_BPM120.mp3 \
"
SRC_URI[sha256sum] = "fa7dffc3087363daf63b21a0f10e09cbfc8d49c39fbc8ff656e12a454aed1928"

inherit allarch

S = "${WORKDIR}"

do_populate_lic[noexec] = "1"
do_compile[noexec] = "1"
do_install() {
    install -d ${D}/media/usb0
    install -m 644 ${S}/143_BPM120.mp3 ${D}/media/usb0/
    eyeD3 ${EYED3_OPTIONS} ${D}/media/usb0/143_BPM120.mp3
}

PACKAGES = "\
    ${PN} \
"

FILES:${PN} = " \
    /media/usb0/* \
"
