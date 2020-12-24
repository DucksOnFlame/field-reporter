cd $(dirname $0)
docker-compose -p service-register -f docker/docker-compose.yml down --remove-orphans