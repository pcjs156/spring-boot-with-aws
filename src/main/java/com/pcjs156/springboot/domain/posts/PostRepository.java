package com.pcjs156.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity class, PK Type>
// 해당 인터페이스를 상속받으면, 자동으로 CRUD 메서드가 생성됨
// +) 필수는 아니지만, Entity와 Repository는 domain package에서 같이 관리하는게 좋음
//    프로젝트 규모가 커져 도메인 별로 프로젝트를 준리해야 할 때 유리함
public interface PostRepository extends JpaRepository<Posts, Long> {
}
