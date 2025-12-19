package com.example.base.security.user.repository;

import com.example.base.security.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByuserId(String userId);
}



/*
 - 학습용 메모
 findByuserId : BY 뒤이 이름으로 해당 도메인(USER)의 변수를 찾고 변수에 선언된 컬럼 찾는순 이다
 조건이 두개라면 AND나 OR 더해서 구현
 @Query : 조건이 많아지거나 복잡해지면 사용
 ex)
    @Query("""
    select u
    from User u
    where u.userId = :userId
    """)
    Optional<User> findByUserId(@Param("userId") String userId);
    Optional<User> findByUserIdAndRole(String userId, String role); : java8이상

    @Query("""
    select u
    from User u
    where u.role in :roles
    """)
    List<User> findByRoles(@Param("roles") List<String> roles);

 */