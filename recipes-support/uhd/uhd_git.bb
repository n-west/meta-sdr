SUMMARY = "Universal Hardware Driver for Ettus Research products."
HOMEPAGE = "http://www.ettus.com"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51b35d652c070d136bf20244494be2d3"

DEPENDS = "git-native python-cheetah-native boost libusb1 uhd-firmware orc-native ncurses"
RDEPENDS_${PN} += "uhd-firmware"

inherit cmake pythonnative

PACKAGES =+ "${PN}-tests ${PN}-examples ${PN}-e1xx"

INSANE_SKIP_${PN} = "dev-so"

FILES_${PN} += "${libdir}/libuhd.so \
                ${libdir}/uhd/utils/*"
FILES_${PN}-tests += "${datadir}/uhd/tests/*"
FILES_${PN}-dbg += "${libdir}/uhd/examples/.debug/* \
                    ${libdir}/uhd/utils/.debug/* \
                    ${libdir}/uhd/tests/.debug/* \
                    ${libdir}/uhd/usrp_e_utils/.debug/*"
FILES_${PN}-examples = "${libdir}/uhd/examples/*"

PACKAGECONFIG ??= ""
PACKAGECONFIG[orc] = "-DENABLE_ORC=ON,-DENABLE_ORC=OFF,orc"

EXTRA_OECMAKE = "-DENABLE_E100=TRUE"

PV = "3.6.2"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=master \
          "
S = "${WORKDIR}/git/host"

SRCREV = "09bd61ccac69f7467092678b8e0a421403fff943"
