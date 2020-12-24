cd $(dirname $0)
docker-compose -p data-fetcher -f docker/docker-compose.yml down --remove-orphans