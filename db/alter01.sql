-- version 1.0.0

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE account
(
    id           UUID                 DEFAULT uuid_generate_v4(),
    company_code VARCHAR(10) NOT NULL,
    user_name    VARCHAR(20) NOT NULL,
    password     TEXT        NOT NULL,
    role         VARCHAR(10),
    created_date timestamp   NOT NULL DEFAULT NOW(),
    updated_date timestamp   NOT NULL DEFAULT NOW(),
    CONSTRAINT account_pk PRIMARY KEY (id)
);

CREATE TABLE payroll
(
    id           UUID                DEFAULT uuid_generate_v4(),
    account_id   UUID       NOT NULL,
    year         VARCHAR(4) NOT NULL,
    month        VARCHAR(2) NOT NULL,
    salary       int        NOT NULL DEFAULT 0,
    created_date timestamp  NOT NULL DEFAULT NOW(),
    updated_date timestamp  NOT NULL DEFAULT NOW(),
    CONSTRAINT payroll_pk PRIMARY KEY (id),
    CONSTRAINT payroll__account_fk FOREIGN KEY (account_id) REFERENCES account (id)
);