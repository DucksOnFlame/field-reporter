cd $(dirname $0)
docker-compose -p data-fetcher -f docker/docker-compose.yml down --remove-orphans
docker build -t data-fetcher -f ./docker/Dockerfile .
docker-compose -p data-fetcher -f docker/docker-compose.yml up -d