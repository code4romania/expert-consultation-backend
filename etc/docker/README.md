# Install docker and docker-compose

* install [Docker](https://docs.docker.com/install/)
* install `docker-compose`
  * with [pip](https://packaging.python.org/tutorials/installing-packages/): `pip install docker-compose`
# Docker-compose scenarios

* create and run docker images for the server (clones the latest version) and all its dependencies:
``` shell
docker-compose -f etc/docker/docker-compose.yml up
```
* create and run docker images for all server dependencies (mongodb):
``` shell
docker-compose -f etc/docker/docker-compose-dev.yml up
```

* in order to remove the volumes (eg. the database volume)  associated with a compose file run:

``` shell
docker-compose -f etc/docker/docker-compose.yml down -v
```
