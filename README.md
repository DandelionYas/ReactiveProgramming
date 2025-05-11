## Setup MongoDB in a docker container
```shell
docker pull mongo
docker run -p 27017:27017 --name mongodb -d mongo
```