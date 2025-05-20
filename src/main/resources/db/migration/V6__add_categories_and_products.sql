create table categories
(
    id   TINYINT AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) not null
);

create table products
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        varchar(255)   not null,
    price       DECIMAL(10, 2) not null,
    description varchar(255)   not null,
    category_id TINYINT,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE RESTRICT
)
