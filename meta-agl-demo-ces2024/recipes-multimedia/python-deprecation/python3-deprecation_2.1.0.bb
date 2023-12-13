DESCRIPTION = "The deprecation library provides a deprecated decorator and a fail_if_not_removed decorator for your tests."
HOMEPAGE = "https://pypi.org/project/deprecation/"
LICENSE = "Apache-2.0"
SECTION = "libs"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

SRC_URI[sha256sum] = "72b3bde64e5d778694b0cf68178aed03d15e15477116add3fb773e581f9518ff"

PYPI_PACKAGE = "deprecation"
inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
