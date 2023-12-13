DESCRIPTION = "eyeD3 is a Python module and command line program for processing ID3 tags. "
HOMEPAGE = "https://pypi.org/project/eyed3/"
LICENSE = "GPL-3.0-only"
SECTION = "multimedia"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8006d9c814277c1bfc4ca22af94b59ee"

SRC_URI[sha256sum] = "93b18e9393376a45114f9409d7cca119fb6f4f9a37d4b697b500af48b4c5cf0f"

PYPI_PACKAGE = "eyeD3"
inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-certifi ${PYTHON_PN}-charset-normalizer \
    ${PYTHON_PN}-deprecation ${PYTHON_PN}-filetype \
    ${PYTHON_PN}-idna ${PYTHON_PN}-packaging \
    ${PYTHON_PN}-pyparsing ${PYTHON_PN}-requests \
    ${PYTHON_PN}-urllib3 \
    "
