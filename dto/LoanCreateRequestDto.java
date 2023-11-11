package com.sbb.flexrate.dto;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.domain.Loan;
import com.sbb.flexrate.member.Member;
import lombok.*;

import java.util.Date;

/*
loan생성 DTO_수정 필요
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanCreateRequestDto {
    //    private Member member;
    private Credit credit;

    private Date birth_year=credit.getMember().getBirth();
    private Boolean gender=credit.getMember().getGender();
    private Long yearly_income;
    private Long loan_cnt;
    private Long loan_amount;
    private Boolean personal_rehabilitation_yn;
    private Boolean personal_rehabilitation_complete_yn;
    private Long company_year;//근속연수
    private Float korea_interest_rate=3.5f;//한국 은행 기준 금리_상수
    private Float index_pc= 1.223714f;//거시경제지표 pca_상수
/*
    public static LoanCreateRequestDto from(Loan loan, Credit credit){
        return LoanCreateRequestDto.builder()
                .birth_year(credit.getMember().getBirth())
                .gender(credit.getMember().getGender())
                .yearly_income(credit.getYearly_income())
                .loan_cnt(credit.getLoan_cnt())
                .loan_amount(credit.getLoan_amount())
                .personal_rehabilitation_yn(loan.getPersonal_rehabilitation_yn())
                .personal_rehabilitation_complete_yn(loan.getPersonal_rehabilitation_complete_yn())
                .company_year(loan.getCompany_year())
                .korea_interest_rate(loan.getKorea_interest_rate())
                .index_pc(loan.getIndex_pc())
                .build();
    }
*/
}