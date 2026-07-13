DROP TABLE IF EXISTS member;

-- member table
CREATE TABLE member (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        user_id VARCHAR(50) NOT NULL,
                        password VARCHAR(50) NOT NULL,
                        user_name VARCHAR(20) NOT NULL
);

-- board table
CREATE TABLE board (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(200) NOT NULL,
                       content TEXT NOT NULL,
                       user_id VARCHAR(50) NOT NULL,
                       file_path VARCHAR(255),
                       created DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- comment 테이블 생성
-- board_id 는 board.id 를 가리키는 외래키(FK) - "이 댓글이 어느 게시글 것인지"를 나타낸다
CREATE TABLE comment (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         content TEXT NOT NULL,
                         user_id VARCHAR(50) NOT NULL,
                         created DATETIME DEFAULT CURRENT_TIMESTAMP,
                         board_id BIGINT NOT NULL,
                         CONSTRAINT fk_comment_board FOREIGN KEY (board_id) REFERENCES board (id)
);

DESC board;
DESC member;
SELECT * FROM member;
