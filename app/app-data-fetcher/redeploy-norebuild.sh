cd $(dirname $0)
sh docker-down.sh
docker build -t data-fetcher -f ./docker/Dockerfile .
docker-compose -p data-fetcher -f docker/docker-compose.yml up -d