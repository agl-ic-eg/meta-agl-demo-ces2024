SUMMARY = "AGL Instrument Cluster Cotainer Integration demo image for eMMC CES2024"
LICENSE = "MIT"

require recipes-platform/images/agl-instrument-cluster-container-demo.bb

OUT_OF_TREE_CONTAINER_CONFIGS = " \
    cm-config-agl-qt-ivi-demo-emmc \
    cm-config-agl-flutter-ivi-demo-emmc \
    cm-config-agl-html5-ivi-demo-emmc \
    cm-config-agl-flutter-ivi-demo-simple-emmc \
"

IMAGE_INSTALL:remove = " \
    cm-config-cluster-demo \
    cm-config-agl-momi-ivi-demo \
    cm-config-agl-momi-ivi-demo-res \
"

IMAGE_INSTALL:append = " \
    cm-config-cluster-demo-emmc \
    cm-config-agl-momi-ivi-demo-emmc \
    cm-config-agl-momi-ivi-demo-res-emmc \
"

