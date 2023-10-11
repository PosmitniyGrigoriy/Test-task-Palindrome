CREATE TABLE palindrome_db.public.users
(
    id         UUID        NOT NULL DEFAULT gen_random_uuid(),
    created_at TIMESTAMP   NOT NULL,
    updated_at TIMESTAMP   NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    login      VARCHAR(30) NOT NULL UNIQUE,
    password   TEXT        NOT NULL,
    last_visit TIMESTAMP   NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE palindrome_db.public.palindromes
(
    id         UUID                  NOT NULL DEFAULT gen_random_uuid(),
    created_at TIMESTAMP             NOT NULL,
    updated_at TIMESTAMP             NOT NULL,
    palindrome VARCHAR(30)           NOT NULL,
    user_id    UUID REFERENCES users NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE palindrome_db.public.statistics
(
    id                 UUID                  NOT NULL DEFAULT gen_random_uuid(),
    created_at         TIMESTAMP             NOT NULL,
    updated_at         TIMESTAMP             NOT NULL,
    user_id            UUID REFERENCES users NOT NULL UNIQUE,
    palindromes_number INT                   NOT NULL,
    total_points       INT                   NOT NULL,
    PRIMARY KEY (id)
);