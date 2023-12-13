DESCRIPTION = "Small and dependency free Python package to infer file type and MIME type \
               checking the magic numbers signature of a file or buffer."
HOMEPAGE = "https://pypi.org/project/filetype/"
LICENSE = "MIT"
SECTION = "libs"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cc0e8af5f14a75ce53b7b9db0f4bd91e"

SRC_URI[sha256sum] = "66b56cd6474bf41d8c54660347d37afcc3f7d1970648de365c102ef77548aadb"

PYPI_PACKAGE = "filetype"
inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
