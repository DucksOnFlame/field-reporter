cd $(dirname $0)
sh docker-down.sh
docker build -t task-service -f ./docker/Dockerfile .
docker-compose -p task-service -f docker/docker-compose.yml up -d