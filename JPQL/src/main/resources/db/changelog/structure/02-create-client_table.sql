CREATE TABLE client (
    id uuid PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL UNIQUE,
    address_id uuid REFERENCES address (id) on delete cascade
--     phone_id integer not null REFERENCES phone (id) on delete cascade
);