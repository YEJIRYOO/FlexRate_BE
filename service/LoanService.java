package com.sbb.flexrate.service;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.domain.Loan;
import com.sbb.flexrate.dto.CreditCreateRequestDto;
import com.sbb.flexrate.dto.LoanCreateRequestDto;
import com.sbb.flexrate.dto.LoanInfoDto;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.member.Member;
import com.sbb.flexrate.member.MemberRepository;
import com.sbb.flexrate.repository.CreditRepository;
import com.sbb.flexrate.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoanService {
    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;

    /*
    //memberId로 해당 member의 credit 정보 반환
    public Loan findMyLoan(Long memberId){
        Optional<Member> member=memberRepository.findById(memberId);
        if(member.isPresent()){
            return member.get().getLoan();
        }
        else throw new DataNotFoundException("Member not found");
    }
    */

    public void updateLoan(Long memberId,LoanCreateRequestDto loanDto){
        Optional<Member> member=memberRepository.findById(memberId);
        if(member.isPresent()){
            Optional<Loan> optionalLoan=loanRepository.findByMemberId(memberId);
            if(optionalLoan.isPresent()){
                Loan loan=optionalLoan.get();
//                loan.setBirth_year(loanDto.getBirth_year()); 성별 생일은 member 고정-> 업데이트 항목에서 제외
//                loan.setGender(loanDto.getGender());
                loan.setYearly_income(loanDto.getYearly_income());
                loan.setLoan_cnt(loanDto.getLoan_cnt());
                loan.setLoan_amount(loanDto.getLoan_amount());
                loan.setCredit_score(loanDto.getCredit_score());
                loan.setPersonal_rehabilitation_yn(loanDto.getPersonal_rehabilitation_yn());
                loan.setPersonal_rehabilitation_complete_yn(loanDto.getPersonal_rehabilitation_complete_yn());
                loan.setCompany_year(loanDto.getCompany_year());
//                loan.setKorea_interest_rate(loanDto.getKorea_interest_rate()); 상수들 고정값-> 업데이트 제외
//                loan.setIndex_pc(loanDto.getIndex_pc());
                loanRepository.save(loan);
            }else {
                System.out.println(memberId);
                throw new DataNotFoundException("해당 Member의 Loan 조회 실패");
            }
        }else{
            throw new DataNotFoundException("Member 조회 실패");
        }
    }

    public LoanInfoDto getLoanInfo(Long memberId){
        Optional<Member> member=memberRepository.findById(memberId);
        if(member.isPresent()){
            Loan loan=member.get().getLoan();
            return LoanInfoDto.from(loan);
        }else throw new DataNotFoundException("Member 조회 실패");
    }
}