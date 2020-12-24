cd $(dirname $0)
docker-compose -p service-register -f docker/docker-compose.yml down --remove-orphans
docker build -t service-register -f ./docker/Dockerfile .
docker-compose -p service-register -f docker/docker-compose.yml up -d