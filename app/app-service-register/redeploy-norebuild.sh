cd $(dirname $0)
sh docker-down.sh
docker build -t service-register -f ./docker/Dockerfile .
docker-compose -p service-register -f docker/docker-compose.yml up -d