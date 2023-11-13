package com.sbb.flexrate.dto;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.domain.Loan;
import com.sbb.flexrate.member.Member;
import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanCreateRequestDto {
    private Member member;
    private Date birth_year;//새로 받는건 아니지 않을까?
    private Boolean gender;
    private Long credit_score;
    private Long yearly_income;
    private Long loan_cnt;
    private Long loan_amount;
    private Boolean personal_rehabilitation_yn;
    private Boolean personal_rehabilitation_complete_yn;
    private Long company_year;//근속연수
    private Float korea_interest_rate=3.5f;//한국 은행 기준 금리_상수
    private Float index_pc= 1.223714f;//거시경제지표 pca_상수
}