CREATE TABLE `survey_answers` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 고유 ID
    `userNo` INT NOT NULL,  -- 사용자 번호
    `age` VARCHAR(10),  -- 나이
    `region` VARCHAR(20),  -- 지역
    `sub_region` JSON,  -- 서브 지역 (JSON 형태로 저장)
    `travelers` VARCHAR(10),  -- 여행자 수
    `budget` VARCHAR(50),  -- 예산
    `preference` VARCHAR(100),  -- 선호도
    `transportation` VARCHAR(50),  -- 교통 수단
    FOREIGN KEY (`userNo`) REFERENCES `users`(`userNo`) ON DELETE CASCADE ON UPDATE CASCADE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;
