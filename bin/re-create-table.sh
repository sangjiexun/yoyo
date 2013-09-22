psql -U yoyo -d yoyo -f yoyo-application/yoyo-application-allinone/src/test/data/drop.sql
mvn -pl yoyo-actor/yoyo-actor-service-api test -Dtest=EntityCreator
