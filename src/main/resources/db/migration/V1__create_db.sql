CREATE TABLE client
(
    id   IDENTITY PRIMARY KEY,
    name VARCHAR(200) NOT NULL
        CONSTRAINT name_client_length
            CHECK length(name) > 2
);

CREATE TABLE planet
(
    id   IDENTITY PRIMARY KEY,
    name VARCHAR(500) NOT NULL
        CONSTRAINT name_planet
            CHECK length(name) > 0
);

CREATE TABLE ticket
(
    id             IDENTITY PRIMARY KEY,
    created_at     TIMESTAMP WITH TIME ZONE,
    client_id      BIGINT,
    from_planet_id BIGINT,
    to_planet_id   BIGINT,
    FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE,
    FOREIGN KEY (from_planet_id) REFERENCES planet (id) ON DELETE CASCADE,
    FOREIGN KEY (to_planet_id) REFERENCES planet (id) ON DELETE CASCADE
)

