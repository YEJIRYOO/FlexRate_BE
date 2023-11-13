package com.sbb.flexrate.dto;

import com.sbb.flexrate.domain.Loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanInfoDto {
    private Date birth_year;
    private Boolean gender;
    private Long yearly_income;
    private Long loan_cnt;
    private Long loan_amount;
    private Long credit_score;
    private Boolean personal_rehabilitation_yn;
    private Boolean personal_rehabilitation_complete_yn;
    private Long company_year;
    private Float korea_interest_rate ;
    private Float index_pc;//거시경제지표 pca_상수: 1.223714고정


    public static LoanInfoDto from(Loan loan){
        return LoanInfoDto.builder()
                .birth_year(loan.getBirth_year())
                .gender(loan.getGender())
                .yearly_income(loan.getYearly_income())
                .loan_cnt(loan.getLoan_cnt())
                .loan_amount(loan.getLoan_amount())
                .credit_score(loan.getCredit_score())
                .personal_rehabilitation_yn(loan.getPersonal_rehabilitation_yn())
                .personal_rehabilitation_complete_yn(loan.getPersonal_rehabilitation_complete_yn())
                .company_year(loan.getCompany_year())
                .korea_interest_rate(loan.getKorea_interest_rate())
                .index_pc(loan.getIndex_pc())
                .build();
    }
}
