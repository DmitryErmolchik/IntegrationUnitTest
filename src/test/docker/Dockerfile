FROM postgres:alpine

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB postgres

COPY sql/* /docker-entrypoint-initdb.d/