package com.sbb.flexrate.dto;

import com.sbb.flexrate.member.Authority;
import com.sbb.flexrate.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.sbb.flexrate.domain.Credit;

import javax.persistence.Column;
import java.util.List;

/*
credit생성( DTO
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCreateRequestDto{
    private Member member;
    private Long existing_credit_score;
    private Long yearly_income;
    private Long company_month;
    private Long loan_cnt;
    private Long loan_amount;
    private Double debt_rate;

    //TODO: 범주형변수_ 수입유형, 고용유형, 자가소유유형
/*
    public static CreditCreateRequestDto from(Credit credit){
        return CreditCreateRequestDto.builder()
                .existing_credit_score(credit.getExisting_credit_score())
                .yearly_income(credit.getYearly_income())
                .company_month(credit.getCompany_month())
                .loan_amount(credit.getLoan_amount())
                .debt_rate(credit.getDebt_rate())
                .build();
    }
   //many 형성됨
 */
}