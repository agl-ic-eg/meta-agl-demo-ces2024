SUMMARY     = "AGL Reference On Demand Navigation application config."
DESCRIPTION = "Config file for on-demand navigation app."
HOMEPAGE    = "https://github.com/YoshitoMomiyama/aglqtnavigation.git"
SECTION     = "apps"
LICENSE     = "Proprietary"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = " \
    file://naviconfig.ini.osm \
    file://naviconfig.ini.mapbox \
    "

inherit allarch

MAPBOX_ACCESS_TOKEN ??= "USEOSM"

NAVICONFIG_BASE_FILE = "${@bb.utils.contains("MAPBOX_ACCESS_TOKEN", "USEOSM", "naviconfig.ini.osm", "naviconfig.ini.mapbox", d)}"

do_compile[noexec] = "1"

do_install () {
    install -D -m 644 ${WORKDIR}/${NAVICONFIG_BASE_FILE} ${D}${sysconfdir}/naviconfig.ini
    sed -i -e 's/MAPBOX_ACCESS_TOKEN/${MAPBOX_ACCESS_TOKEN}/' ${D}${sysconfdir}/naviconfig.ini
}
