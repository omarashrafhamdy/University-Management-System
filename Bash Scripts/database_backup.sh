#!/bin/bash

DB_USER=University
DB_PASSWORD=123
DB_SID=XE

BACKUP_DIR="/d/ITI/Case Study/Bash Scripts/Backup"

DATE_FORMAT=$(date +"%Y%m%d_%H%M%S")

EXPORT_FILE="backup_${DATE_FORMAT}.dmp"

expdp ${DB_USER}/${DB_PASSWORD}@${DB_SID} DIRECTORY=DATA_PUMP_DIR DUMPFILE=${EXPORT_FILE} FULL=Y

if [ $? -eq 0 ]; then
    cp "/c/oraclexe/app/oracle/admin/XE/dpdump/${EXPORT_FILE}" "${BACKUP_DIR}/"
    echo "Database backup successful. File: ${EXPORT_FILE} | date: $(date)" >> "${BACKUP_DIR}/backuplogs.txt"
else
    echo "Error: Database backup failed. | date: $(date)" >> "${BACKUP_DIR}/backuplogs.txt"
fi
