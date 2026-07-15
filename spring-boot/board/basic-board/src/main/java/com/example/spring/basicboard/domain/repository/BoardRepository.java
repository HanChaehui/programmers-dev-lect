package com.example.spring.basicboard.domain.repository;

import com.example.spring.basicboard.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// * 클래스와 인터페이스의 상속 규칙은 다르다.
// 클래스 : extends는 딱 하나만 (다중 상속 금지)
// 인터페이스 : extends를 여러 개 나열 가능

// 클래스 다중 상속 금지 이유 (다이아몬드 문제)
// - 클래스는 상태(필드) + 구현(메서드 몸통)을 상속받음
// -> 두 부모의 같은 필드/메서드가 다른 내용을 가진다면 자식은 어느 쪽을 따라야할 지 모호함 (모호성)
// - 인터페이스는 기본적으로 구현없는 약속(추상 메서드)만 상속받음
// -> 상속 받을 클래스들의 충돌한 내용물이 없다.
// -> 양쪽에 같은 시그니처가 있더라도 "지켜야 할 약속 1개"로 합쳐진다.
// -> default메서드는 몸통을 가질 수 있는데, 그땐 컴파일 에러를 내서 자식이 직접 오버라이딩 하도록 강제한다.
public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
}