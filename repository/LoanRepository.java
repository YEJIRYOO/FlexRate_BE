package com.sbb.flexrate.repository;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan,Long> {
    Optional<Loan> findByMemberId(Long memberId);//사용자 아이디 기반 credit 정보 조회
}