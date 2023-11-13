package com.sbb.flexrate.repository;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CreditRepository extends JpaRepository<Credit,Long> {
   Optional<Credit> findByMemberId(Long memberId);//사용자 아이디 기반 credit 정보 조회
}