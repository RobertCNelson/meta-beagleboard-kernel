SECTION = "kernel"
DESCRIPTION = "Linux kernel for BeagleBoard devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

# Look in the generic major.minor directory for files
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.1:"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|omap3|omap4"

S = "${WORKDIR}/git"

tag = "4.1.4-ti-r9"

SRCREV = "b16e5f7b8a29f130ebcac9311988edbcc944b361"
PV = "${BRANCH}+git${SRCPV}"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

MULTI_CONFIG_BASE_SUFFIX = ""

KERNEL_GIT_URI = "https://github.com/beagleboard/linux"
KERNEL_GIT_PROTOCOL = "https"
SRC_URI += "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};tag=${tag} \
            file://defconfig \
           "
