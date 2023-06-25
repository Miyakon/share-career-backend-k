FROM --platform=linux/x86_64 mysql:8.0.31-debian

COPY ./data/ /docker-entrypoint-initdb.d/

ENV MYSQL_ROOT_PASSWORD=root