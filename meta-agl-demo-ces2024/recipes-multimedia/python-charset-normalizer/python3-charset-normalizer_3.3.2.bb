DESCRIPTION = "A library that helps you read text from an unknown charset encoding."
HOMEPAGE = "https://pypi.org/project/charset-normalizer/"
LICENSE = "MIT"
SECTION = "libs"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0974a390827087287db39928f7c524b5"

SRC_URI[sha256sum] = "f30c3cb33b24454a82faecaf01b19c18562b1e89558fb6c56de4d9118a032fd5"

PYPI_PACKAGE = "charset-normalizer"
inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
