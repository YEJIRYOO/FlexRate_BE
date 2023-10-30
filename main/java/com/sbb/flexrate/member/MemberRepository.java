package com.sbb.flexrate.member;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
사용자 조회 repo
account를 이용하여 조회 _email 로그인 시 findByEmail
 */
@Transactional
public interface MemberRepository extends JpaRepository<Member,Long>{
    Optional<Member> findByAccount(String account);
}

/*
@Transactional : 데이터베이스 트랜잭션 관리
    -> 메서드 레벨 적용 시 해당 메서드에서 실행되는 작업들
    하나의 트랜잭션으로 묶임

역할)
관리: 트랜잭션 관리 서비스를 활성화하고, 메서드 내의 작업을 트랜잭션으로 묶어줌
경계 설정: 메서드 실행 전에 트랜잭션을 시작하고, 메서드가 성공적으로 완료되면 트랜잭션을 커밋하고, 예외가 발생하면 롤백
예외 처리 및 롤백: 메서드 내에서 예외가 발생하면 트랜잭션은 롤백됩니다.
    -> 이전 상태로 되돌려 일관성 유지
속성 설정: 트랜잭션의 속성을 설정 가능.(격리 수준, 타임아웃, 읽기 전용 등의 속성)
 */