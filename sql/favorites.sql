CREATE TABLE favorites (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- 즐겨찾기 아이디
    user_no INT,                        -- 사용자 ID (users 테이블의 외래키)
    place_name VARCHAR(255) NOT NULL,    -- 장소 이름
    place_address VARCHAR(255) NOT NULL, -- 장소 주소
    place_type INT NOT NULL,            -- 장소 유형 (1: 자연 관광지, 2: 문화 유적지 등)
    place_score FLOAT NOT NULL,         -- 장소 평점
    FOREIGN KEY (user_no) REFERENCES users(userNo) -- users 테이블의 userNo와 연결
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
