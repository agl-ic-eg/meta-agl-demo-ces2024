#!/bin/sh

ip link add vxcan1 type vxcan peer name vxcan0
ip link set vxcan1 up
