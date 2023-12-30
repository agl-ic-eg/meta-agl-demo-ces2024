SUMMARY = "Cross SDK for AGL Instrument Cluster Cotainer Integration Host Demo image"
LICENSE = "MIT"

require recipes-platform/images/agl-instrument-cluster-container-demo.bb

CONTAINER_IMAGES = " "
OUT_OF_TREE_CONTAINER_IMAGES = " "

IMAGE_INSTALL += " \
    e2fsprogs-e2fsck e2fsprogs-mke2fs \
    gdb glibc-thread-db \
    libasan libubsan liblsan libtsan \
    htop util-linux-taskset util-linux-chrt \
    libcgroup \
"

inherit agl-crosssdk
