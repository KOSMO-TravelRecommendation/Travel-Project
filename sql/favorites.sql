CREATE TABLE favorites (
    favorite_id INT AUTO_INCREMENT PRIMARY KEY,
    userNo INT NOT NULL,
    place_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userNo) REFERENCES users(userNo)
);
