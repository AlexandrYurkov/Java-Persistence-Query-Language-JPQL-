CREATE TABLE address (
    id uuid PRIMARY KEY NOT NULL,
    address VARCHAR(60) NOT NULL
--     clientId integer not null references client (id) on DELETE cascade
);