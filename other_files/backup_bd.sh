#!/bin/bash
find /srv/backups -name "*.gz" -mtime +7 -exec rm -f {} \;
mysqldump -uoleg -hlocalhost -pBeHapp2014 shopcrm channeltype clients clienttype customuser deliverystatus deliverytype moneyback np_contactperson np_counterparty orderdetails orders orderstatus paymentstatus paymenttype refusedorders statement | gzip -c > /srv/backups/shopcrm_db_`date "+%Y-%m-%d"`.gz
ftp -n 176.38.17.13 <<END_SCRIPT
quote USER sribnyk
quote PASS BeHapp2014
prompt
binary
lcd /srv/backups
cd /AiDisk_a1/sribnyk_backup
put shopcrm_db_`date "+%Y-%m-%d"`.gz
quit
END_SCRIPT

