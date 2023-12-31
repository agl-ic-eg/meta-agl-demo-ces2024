DESCRIPTION = "Highway of Solitude from BGMer."
HOMEPAGE = "https://bgmer.net/"
LICENSE = "CLOSED"
SECTION = "Multimedia"

include recipes-multimedia/music-data/mp3-music-data.inc

MP3_MUSIC_DATA_ARTWORK = "fly-dog.jpg"
MP3_MUSIC_DATA_TITLE = "Highway of Solitude"
MP3_MUSIC_DATA_AIRTIST = "BGMer"
MP3_MUSIC_DATA_ALBUM = "BGMer"

SRC_URI = " \
    https://bgmer.net/wp-content/uploads/2022/03/217_BPM146.mp3 \
"
SRC_URI[sha256sum] = "e3ebfe695dbea072afb5990cca2cf428a91f342997c4a4f7ce3bf18ee3101ea6"


inherit allarch

S = "${WORKDIR}"

do_populate_lic[noexec] = "1"
do_compile[noexec] = "1"
do_install() {
    install -d ${D}/media/usb0
    install -m 644 ${S}/217_BPM146.mp3 ${D}/media/usb0/
    eyeD3 ${EYED3_OPTIONS} ${D}/media/usb0/217_BPM146.mp3
}

PACKAGES = "\
    ${PN} \
"

FILES:${PN} = " \
    /media/usb0/* \
"
