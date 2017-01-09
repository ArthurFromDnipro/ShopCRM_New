#!/bin/bash
curl -s http://crm.sribnyk.com.ua/j_spring_security_check -c shopcrmtmp -d "j_login=admin&j_password=BeHapp2014"
curl -s http://crm.sribnyk.com.ua/updatenp -b shopcrmtmp
