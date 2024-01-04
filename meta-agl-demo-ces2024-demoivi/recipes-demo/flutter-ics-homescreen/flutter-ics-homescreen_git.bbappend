FILESEXTRAPATHS:prepend := "${THISDIR}/flutter-ics-homescreen:"

SRC_URI:append = " \
    file://0001-Initial-radio-implementation.patch \
    file://0002-Initial-mediaplayer-implementation.patch \
"

SRCREV = "fcd868bd73d35bd79074f3425317152565aeb275"
