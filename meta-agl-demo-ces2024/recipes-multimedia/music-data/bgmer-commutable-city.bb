DESCRIPTION = "Cmmutable City from BGMer."
HOMEPAGE = "https://bgmer.net/"
LICENSE = "CLOSED"
SECTION = "Multimedia"

include recipes-multimedia/music-data/mp3-music-data.inc

MP3_MUSIC_DATA_ARTWORK = "prage-sky.jpg"
MP3_MUSIC_DATA_TITLE = "Cmmutable City"
MP3_MUSIC_DATA_AIRTIST = "BGMer"
MP3_MUSIC_DATA_ALBUM = "BGMer"

SRC_URI = " \
    https://bgmer.net/wp-content/uploads/2023/01/355_BPM128.mp3 \
"
SRC_URI[sha256sum] = "8b93a25d80d99e1a49382935f5867e51d3b733247cb5653c84b4f6ac33e5eb91"


inherit allarch

S = "${WORKDIR}"

do_populate_lic[noexec] = "1"
do_compile[noexec] = "1"
do_install() {
    install -d ${D}/media/usb0
    install -m 644 ${S}/355_BPM128.mp3 ${D}/media/usb0/
    eyeD3 ${EYED3_OPTIONS} ${D}/media/usb0/355_BPM128.mp3
}

PACKAGES = "\
    ${PN} \
"

FILES:${PN} = " \
    /media/usb0/* \
"
