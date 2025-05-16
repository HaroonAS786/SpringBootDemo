CREATE TABLE tags
(
    id   INT AUTO_INCREMENT PRIMARY KEY,  -- Change to BIGINT to match user_tags
    name VARCHAR(255) NOT NULL
);


CREATE TABLE user_tags
(
    user_id BIGINT NOT NULL,
    tag_id  INT NOT NULL,  -- Change to BIGINT to match tags.id
    PRIMARY KEY (user_id, tag_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tags (id) ON DELETE CASCADE
);