mvn clean install

sh ./app/app-kafka-broker/redeploy.sh
sh ./app/app-service-register/redeploy-norebuild.sh
sh ./app/app-task-service/redeploy-norebuild.sh
sh ./app/app-data-fetcher/redeploy-norebuild.sh
