cd $(dirname $0)
docker-compose -p kafka -f docker/docker-compose.yml down --remove-orphans
docker-compose -p kafka -f docker/docker-compose.yml up -d