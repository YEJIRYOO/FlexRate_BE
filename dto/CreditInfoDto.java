package com.sbb.flexrate.dto;

import com.sbb.flexrate.domain.Credit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditInfoDto {//마이페이지 credit 정보
    private Long existing_credit_score;//사용자 기존 신용 점수
    private Long yearly_income;
    private Long company_month;//근무월수
    private Long loan_cnt;//이미 대출하고 있는 건 수
    private Long loan_amount;//이미 대출하고 있는 금액
    private Double debt_rate;//부채비율

    public static CreditInfoDto from(Credit credit){//객체 생성해서 return
        return CreditInfoDto.builder()
                .existing_credit_score(credit.getExisting_credit_score())
                .yearly_income(credit.getYearly_income())
                .company_month(credit.getCompany_month())
                .loan_cnt(credit.getLoan_cnt())
                .loan_amount(credit.getLoan_amount())
                .debt_rate(credit.getDebt_rate())
                .build();
    }
}