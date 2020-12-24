mvn clean install

sh ./kafka-broker/redeploy.sh
sh ./service-register/redeploy-norebuild.sh
sh ./data-fetcher/redeploy-norebuild.sh
