package com.example.spring.basicboard.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "board")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, length = 50)
    private String userId;

    @Column(length = 255)
    private String filePath;

    // 원래 2026-01-01T00:00:00
    // -> 2026-01-01 00:00
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime created;

    // * 게시글 수정
    // setter 대신 해당 메서드를 두는 이유 + JPA 변경 감지
    // - 이 엔티티는 @Getter만 존재하고 @Setter는 없다. -> 아무데서나 필드를 바꾸지 못하게 하기 위해
    // - setter를 열어두면 값이 언제 어디서 바뀌는지 추적이 어려워진다.
    // - 대신 게시글을 수정하는 의도가 드러나는 메서드 하나로 변경 지점을 모은다. (도메인 주도 스타일)
    // * JPA 변경 감지 (dirty checking)
    // - 트랜잭션 안에서 조회한 엔티티(영속 상태)의 필드를 바꾸면,
    // 트랜잭션이 끝날 때 JPA가 바뀐 것을 감지하여 UPDATE SQL을 자동으로 실행한다.
    // - 그래서 따로 boardListRepository에서 호출을 날리지 않아도 된다.
    public void update(String title, String content, String filePath) {
        this.title = title;
        this.content = content;
        this.filePath = filePath;
    }
}
