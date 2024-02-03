#!/bin/bash

log_file="D:/ITI/Case Study/Bash Scripts/disk_log.txt"

threshold=50

disk_space=`df -h | awk ' NR==2 {print $6}' | sed 's/%//'`
echo $disk_space

if [[ $disk_space -gt $threshold ]]; then
	echo "Warning Disk Space Is Above $threshold% | date: $(date)" >> /D/ITI/Case\ Study/Bash\ Scripts/disk_log.txt
else
	echo "Disk Space Is Under $threshold% | date: $(date)" >> /D/ITI/Case\ Study/Bash\ Scripts/disk_log.txt
fi