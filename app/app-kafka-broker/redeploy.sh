cd $(dirname $0)
sh docker-down.sh
docker-compose -p kafka -f docker/docker-compose.yml up -d