create table Profiles
(
    id  BIGINT PRIMARY KEY,
    bio TEXT,
    phone_number varchar(15),
    date_of_birth DATE,
    loyalty_points INT UNSIGNED DEFAULT 0,
    FOREIGN KEY (id) REFERENCES users(id)
)