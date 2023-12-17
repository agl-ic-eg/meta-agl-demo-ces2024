SUMMARY = "Virtio-loopback-adapter application"
DESCRIPTION = "Adapter bridge for virtio-loopback"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.md;md5=ecc9c54ada6f0c33054d3bde010744f7"

SRC_URI = " \
    git://github.com/AGLExport/adapter_app.git;protocol=https;branch=multi-sound-demo-dev \
    "
SRCREV = "5407423db8ec1cf462f3a3e830d35e27fb82a525"

PV = "1.0.1+rev${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = " \
    --enable-vhost-user-sound \
    "
