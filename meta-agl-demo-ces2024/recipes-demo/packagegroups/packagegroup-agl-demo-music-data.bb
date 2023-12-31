SUMMARY = "Demo Music Data"
DESCRIPTION = "A packages group for Demo Music."

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-demo-music-data \
    "
RDEPENDS:${PN} += " \
    bgmer-beginning bgmer-beginning-of-hostilities \
    bgmer-childhood-memories bgmer-cosmos-at-sunset \
    bgmer-dawn-of-21st-century bgmer-deep-sea-and-space \
    bgmer-departure-progress bgmer-fire-cracker \
    bgmer-flame-dance bgmer-imaginary-campus \
    bgmer-party-maker bgmer-whistling \
    bgmer-commutable-city bgmer-departing-for-battle \
    bgmer-highway-of-slitude bgmer-filex \
    bgmer-loophole-johnny bgmer-black-cat \
    \
    symlink-music-dir\
    "
