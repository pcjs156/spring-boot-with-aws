package com.pcjs156.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 필수 annotation이 아닌 lombok을 위로 씀으로써,
// Kotlin 도입 등의 개선이 있을 경우 쉽게 삭제할 수 있도록 함
@Getter
@NoArgsConstructor
// 테이블과 링크될 클래스임을 나타냄
@Entity
public class Posts { // Camel case가 underscore naming으로 전환되므로, 테이블 이름은 posts
    // 해당 테이블의 PK 필드
    @Id
    // PK의 생성 규칙을 의미함 (Spring Boot 2.0에서는 GenerationType.IDENTITY를 추가해야 auto-increment됨)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column이 없어도 자동으로 Column이 추가되기는 하는데,
    // nullable(기본값 true)이나 기타 다른 설정을 추가하기 위해 사용함
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // null=True로 DDL이 생성됨
    private String author;

    // Entity에 Setter를 만들면 언제 어디서 인스턴스 값이 바뀌는지 알 수 없으므로 사용 XXX
    // 대신 특정 필드에 대한 값 변경이 필요하면, 그 목적과 의도를 나타낼 수 있는 메서드를 명시적으로 추가해 주어야 함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
