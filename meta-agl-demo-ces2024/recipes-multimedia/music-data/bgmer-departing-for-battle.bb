DESCRIPTION = "Departing for battle from BGMer."
HOMEPAGE = "https://bgmer.net/"
LICENSE = "CLOSED"
SECTION = "Multimedia"

include recipes-multimedia/music-data/mp3-music-data.inc

MP3_MUSIC_DATA_ARTWORK = "edinburgh-castle.jpg"
MP3_MUSIC_DATA_TITLE = "Departing for battle"
MP3_MUSIC_DATA_AIRTIST = "BGMer"
MP3_MUSIC_DATA_ALBUM = "BGMer"

SRC_URI = " \
    https://bgmer.net/wp-content/uploads/2021/05/100_BPM142.mp3 \
"
SRC_URI[sha256sum] = "7aed0dd6b26644ae87e4026590a657c6dca5b760d2d5b10f58a3313de9d92f3a"

inherit allarch

S = "${WORKDIR}"

do_populate_lic[noexec] = "1"
do_compile[noexec] = "1"
do_install() {
    install -d ${D}/media/usb0
    install -m 644 ${S}/100_BPM142.mp3 ${D}/media/usb0/
    eyeD3 ${EYED3_OPTIONS} ${D}/media/usb0/100_BPM142.mp3 
}

PACKAGES = "\
    ${PN} \
"

FILES:${PN} = " \
    /media/usb0/* \
"
