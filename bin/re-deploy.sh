#!/bin/sh
asadmin undeploy yoyo-application-allinone
asadmin deploy yoyo-application/yoyo-application-allinone/target/yoyo-application-allinone.ear
