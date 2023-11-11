package com.sbb.flexrate.service;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.domain.Loan;
import com.sbb.flexrate.dto.CreditCreateRequestDto;
import com.sbb.flexrate.dto.LoanCreateRequestDto;
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
    private final CreditRepository creditRepository;

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

    public Loan findMyLoan(Long creditId){
        Optional<Credit>credit=creditRepository.findById(creditId);
        if(credit.isPresent()){
            return credit.get().getLoan();
        }
        else throw new DataNotFoundException("Credit not found");
    }
    //loan 수정_repo저장
    public void updateLoan(Long creditId, LoanCreateRequestDto loanDto){
        Optional<Credit> credit=creditRepository.findById(creditId);
//        Optional<Member> member=memberRepository.findById(memberId);
        if(credit.isPresent()){
            Loan loan=credit.get().getLoan();
            if(loan!=null){
                loan.setBirth_year(loanDto.getBirth_year());
                loan.setGender(loanDto.getGender());
                loan.setYearly_income(loanDto.getYearly_income());
                loan.setLoan_cnt(loanDto.getLoan_cnt());
                loan.setLoan_amount(loanDto.getLoan_amount());
                loan.setPersonal_rehabilitation_yn(loanDto.getPersonal_rehabilitation_yn());
                loan.setPersonal_rehabilitation_complete_yn(loanDto.getPersonal_rehabilitation_complete_yn());
                loan.setCompany_year(loanDto.getCompany_year());
                loan.setKorea_interest_rate(loanDto.getKorea_interest_rate());
                loan.setIndex_pc(loanDto.getIndex_pc());
                loanRepository.save(loan);
            }else {
                throw new DataNotFoundException("Loan not found for this member");
            }
        }else {
            throw new DataNotFoundException("Credit not found");
        }
    }

}
