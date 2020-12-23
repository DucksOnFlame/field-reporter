cd $(dirname $0)
docker-compose -f docker/docker-compose.yml down
docker build -t service-register -f ./docker/Dockerfile .
docker-compose -f docker/docker-compose.yml up -d