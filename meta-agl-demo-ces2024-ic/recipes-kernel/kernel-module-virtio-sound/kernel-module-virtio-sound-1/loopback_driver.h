// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * Based on virtio_mmio.c
 *   Copyright 2011-2014, ARM Ltd.
 *
 * Copyright 2022-2023 Virtual Open Systems SAS.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
#ifndef __LOOPBACK_H__
#define __LOOPBACK_H__

#define DRIVER	"LOOPBACK"

/* max Minor devices */
#define MAX_DEV	1

/* Define mmap elements limit */
#define MMAP_LIMIT	200

#ifdef DEBUG
#define DBG(...) pr_crit(__VA_ARGS__)
#else
#define DBG(...)
#endif /* DEBUG */

/*
 * The alignment to use between consumer and producer parts of vring.
 * Currently hardcoded to the page size.
 */
#define VIRTIO_MMIO_VRING_ALIGN		 PAGE_SIZE

#define to_virtio_mmio_device(_plat_dev) \
	container_of(_plat_dev, struct virtio_mmio_device, vdev)

typedef struct virtio_device_info_struct {
	unsigned long magic;
	unsigned long version;
	unsigned long device_id;
	unsigned long vendor;
} virtio_device_info_struct_t;

typedef struct virtio_neg {
	uint64_t notification;
	uint64_t data;
	uint64_t size;
	bool read;
	atomic_t done;
} virtio_neg_t;

struct virtio_mmio_device {
	struct virtio_device vdev;
	struct platform_device *pdev;

	void __iomem *base;
	unsigned long version;

	/* A list of queues so we can dispatch IRQs */
	spinlock_t lock;
	struct list_head virtqueues;
};

struct virtio_mmio_vq_info {
	/* the actual virtqueue */
	struct virtqueue *vq;

	/* the list node for the virtqueues list */
	struct list_head node;
};


/*
 * Print the pdev:
 *
 *static void print_virtio_pdev(struct platform_device *pdev)
 *{
 *	int i;
 *
 *	pr_info("Print the pdev:\n");
 *	pr_info("\t.name = %s\n", pdev->name);
 *	pr_info("\t.id = %d\n", pdev->id);
 *	pr_info("\t.num_resources = %d\n", pdev->num_resources);
 *
 *	for (i=0; i < pdev->num_resources; i++) {
 *		pr_info("\t.num_resource = %d\n", i);
 *		pr_info("\t\t.start = 0x%llx\n", pdev->resource[i].start);
 *		pr_info("\t\t.end = 0x%llx\n", pdev->resource[i].end);
 *		pr_info("\t\t.flags = 0x%lx\n", pdev->resource[i].flags);
 *	}
 *}
 *
 *Result:
 *
 *	.name = a003e00.virtio_mmio
 *	.id = -1
 *	.num_resources = 2
 *	.num_resource = 0
 *		.start = 0xa003e00
 *		.end = 0xa003fff
 *		.flags = 0x200
 *	.num_resource = 1
 *		.start = 0x2c
 *		.end = 0x2c
 *		.flags = 0x401
 */

/* mmap finctionality */
#ifndef VM_RESERVED
#define VM_RESERVED (VM_DONTEXPAND | VM_DONTDUMP)
#endif

struct mmap_info {
	void *data;
	int reference;
};

void print_neg_flag(uint64_t neg_flag, bool read)
{
	if (read)
		DBG("Read:\n");
	else
		DBG("Write:\n");

	switch (neg_flag) {
	case VIRTIO_MMIO_MAGIC_VALUE:		//0x000
		DBG("\tVIRTIO_MMIO_MAGIC_VALUE\n");
		break;
	case VIRTIO_MMIO_VERSION:		//0x004
		DBG("\tVIRTIO_MMIO_VERSION\n");
		break;
	case VIRTIO_MMIO_DEVICE_ID:		//0x008
		DBG("\tVIRTIO_MMIO_DEVICE_ID\n");
		break;
	case VIRTIO_MMIO_VENDOR_ID:		//0x00c
		DBG("\tVIRTIO_MMIO_VENDOR_ID\n");
		break;
	case VIRTIO_MMIO_DEVICE_FEATURES:	//0x010
		DBG("\tVIRTIO_MMIO_DEVICE_FEATURES\n");
		break;
	case VIRTIO_MMIO_DEVICE_FEATURES_SEL:	//0x014
		DBG("\tVIRTIO_MMIO_DEVICE_FEATURES_SEL\n");
		break;
	case VIRTIO_MMIO_DRIVER_FEATURES:	//0x020
		DBG("\tVIRTIO_MMIO_DRIVER_FEATURES\n");
		break;
	case VIRTIO_MMIO_DRIVER_FEATURES_SEL:	//0x024
		DBG("\tVIRTIO_MMIO_DRIVER_FEATURES_SEL\n");
		break;
	case VIRTIO_MMIO_GUEST_PAGE_SIZE:	//0x028
		DBG("\tVIRTIO_MMIO_GUEST_PAGE_SIZE\n");
		break;
	case VIRTIO_MMIO_QUEUE_SEL:		//0x030
		DBG("\tVIRTIO_MMIO_QUEUE_SEL\n");
		break;
	case VIRTIO_MMIO_QUEUE_NUM_MAX:		//0x034
		DBG("\tVIRTIO_MMIO_QUEUE_NUM_MAX\n");
		break;
	case VIRTIO_MMIO_QUEUE_NUM:		//0x038
		DBG("\tVIRTIO_MMIO_QUEUE_NUM\n");
		break;
	case VIRTIO_MMIO_QUEUE_ALIGN:		//0x03c
		DBG("\tVIRTIO_MMIO_QUEUE_ALIGN\n");
		break;
	case VIRTIO_MMIO_QUEUE_PFN:		//0x040
		DBG("\tVIRTIO_MMIO_QUEUE_PFN\n");
		break;
	case VIRTIO_MMIO_QUEUE_READY:		//0x044
		DBG("\tVIRTIO_MMIO_QUEUE_READY\n");
		break;
	case VIRTIO_MMIO_QUEUE_NOTIFY:		//0x050
		DBG("\tVIRTIO_MMIO_QUEUE_NOTIFY\n");
		break;
	case VIRTIO_MMIO_INTERRUPT_STATUS:	//0x060
		DBG("\tVIRTIO_MMIO_INTERRUPT_STATUS\n");
		break;
	case VIRTIO_MMIO_INTERRUPT_ACK:		//0x064
		DBG("\tVIRTIO_MMIO_INTERRUPT_ACK\n");
		break;
	case VIRTIO_MMIO_STATUS:		//0x070
		DBG("\tVIRTIO_MMIO_STATUS\n");
		break;
	case VIRTIO_MMIO_QUEUE_DESC_LOW:	//0x080
		DBG("\tVIRTIO_MMIO_QUEUE_DESC_LOW\n");
		break;
	case VIRTIO_MMIO_QUEUE_DESC_HIGH:	//0x084
		DBG("\tVIRTIO_MMIO_QUEUE_DESC_HIGH\n");
		break;
	case VIRTIO_MMIO_QUEUE_AVAIL_LOW:	//0x090
		DBG("\tVIRTIO_MMIO_QUEUE_AVAIL_LOW\n");
		break;
	case VIRTIO_MMIO_QUEUE_AVAIL_HIGH:	//0x094
		DBG("\tVIRTIO_MMIO_QUEUE_AVAIL_HIGH\n");
		break;
	case VIRTIO_MMIO_QUEUE_USED_LOW:	//0x0a0
		DBG("\tVIRTIO_MMIO_QUEUE_USED_LOW\n");
		break;
	case VIRTIO_MMIO_QUEUE_USED_HIGH:	//0x0a4
		DBG("\tVIRTIO_MMIO_QUEUE_USED_HIGH\n");
		break;
	case VIRTIO_MMIO_SHM_SEL:		//0x0ac
		DBG("\tVIRTIO_MMIO_SHM_SEL\n");
		break;
	case VIRTIO_MMIO_SHM_LEN_LOW:		//0x0b0
		DBG("\tVIRTIO_MMIO_SHM_LEN_LOW\n");
		break;
	case VIRTIO_MMIO_SHM_LEN_HIGH:		//0x0b4
		DBG("\tVIRTIO_MMIO_SHM_LEN_HIGH\n");
		break;
	case VIRTIO_MMIO_SHM_BASE_LOW:		//0x0b8
		DBG("\tVIRTIO_MMIO_SHM_BASE_LOW\n");
		break;
	case VIRTIO_MMIO_SHM_BASE_HIGH:		//0x0bc
		DBG("\tVIRTIO_MMIO_SHM_BASE_HIGH\n");
		break;
	case VIRTIO_MMIO_CONFIG_GENERATION:	//0x0fc
		DBG("\tVIRTIO_MMIO_CONFIG_GENERATION\n");
		break;
	default:
		if (neg_flag >= VIRTIO_MMIO_CONFIG)
			DBG("\tVIRTIO_MMIO_CONFIG\n");
		else
			DBG("\tNegotiation flag Unknown: %lld\n", neg_flag);
		return;
	}
}

void print_data(const void *buf, size_t size)
{
	int offset = 10;
	int i, j;

	DBG("Print data from linux virtio-rng side:\n");

	printk(KERN_CRIT "");

	for (i = 0; i < size; i += offset) {
		printk(KERN_CONT "\t\t");

		for (j = i; (j < i + offset) && (j < size); j++)
			printk(KERN_CONT "%d, ", *((uint8_t *)(buf + j)));

		printk(KERN_CRIT "");
	}
}

typedef struct efd_data {
	int efd[2];
	int pid;
} efd_data_t;

/* IOCTL defines */
#define EFD_INIT _IOC(_IOC_WRITE, 'k', 1, sizeof(efd_data))
#define WAKEUP _IOC(_IOC_WRITE, 'k', 2, 0)
#define START_LOOPBACK _IOC(_IOC_WRITE, 'k', 3, sizeof(virtio_device_info_struct_t))
#define IRQ _IOC(_IOC_WRITE, 'k', 4, sizeof(int))
#define SHARE_VQS _IOC(_IOC_WRITE, 'k', 5, sizeof(uint32_t))
#define SHARE_BUF _IOC(_IOC_WRITE, 'k', 6, sizeof(uint64_t))
#define SHARE_COM_STRUCT _IOC(_IOC_WRITE, 'k', 7, 0)

/* device data holder, this structure may be extended to hold additional data */
struct loopback_device_data {
	struct cdev cdev;
};

#endif /* __VIRTUALNET_H__ */
