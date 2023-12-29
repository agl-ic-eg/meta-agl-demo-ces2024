#!/bin/bash

max_retry_count=100
retry_interval=0.1

retry_count=0
while true; do
  ip link set vxcan0 up && break

  retry_count=$((retry_count + 1))
  if [ $retry_count -eq $max_retry_count ]; then
    echo "Error: vxcan0 activate failed after $max_retry_count attempts."
    break
  fi

  sleep $retry_interval
done
