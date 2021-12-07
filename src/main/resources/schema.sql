CREATE TABLE study
(
    id IDENTITY PRIMARY KEY,
    date_time_creation TIMESTAMP NULL,
    topic              VARCHAR(45) NULL,
    tag                VARCHAR(45) NULL,
    url                VARCHAR(255) NULL,
    description        VARCHAR(255) NULL,
    consumed           BOOLEAN NULL
);