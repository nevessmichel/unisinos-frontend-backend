--liquibase formatted sql

--changeset your.name:Michel labels:example-label context:example-context
--comment: example comment
create table users (
    email varchar(255) primary key not null,
    name varchar(50) not null,
    password varchar(50)
)
--rollback DROP TABLE users;