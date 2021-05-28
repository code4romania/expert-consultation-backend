cd /root/expert-consultation-backend
git pull

cd etc/docker
if [ ! -f .env ]; then
        mv .env.example .env
fi

docker-compose build --no-cache
docker-compose down
docker-compose up -d 