cd $(dirname $0)
docker-compose -p task-service -f docker/docker-compose.yml down --remove-orphans