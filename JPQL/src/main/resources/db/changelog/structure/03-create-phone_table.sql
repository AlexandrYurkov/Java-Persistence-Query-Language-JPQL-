CREATE TABLE phone (
    id uuid PRIMARY KEY NOT NULL,
    number VARCHAR(30) not null,
    client_id uuid references client (id) on DELETE cascade
);