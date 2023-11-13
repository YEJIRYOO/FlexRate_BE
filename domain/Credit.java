package com.sbb.flexrate.domain;

import com.sbb.flexrate.dto.CreditCreateRequestDto;
import com.sbb.flexrate.member.Authority;
import com.sbb.flexrate.member.Member;
import com.sbb.flexrate.domain.Loan;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="credit")
public class Credit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name="credit_score")
    private Long existing_credit_score;//사용자 기존 신용 점수

    @Column
    private Long yearly_income;//연수입

    @Column
    private Long company_month;//근무월수

    @Column
    private Long loan_cnt;//이미 대출하고 있는 건 수

    @Column
    private Long loan_amount;//이미 대출하고 있는 금액

    @Column
    private Double debt_rate;//부채비율

    //TODO: 범주형변수_ 수입유형, 고용유형, 자가소유유형
    public static Credit from(CreditCreateRequestDto creditDto){
        return Credit.builder()
                .existing_credit_score(creditDto.getExisting_credit_score())
                .yearly_income(creditDto.getYearly_income())
                .company_month(creditDto.getCompany_month())
                .loan_cnt(creditDto.getLoan_cnt())
                .loan_amount(creditDto.getLoan_amount())
                .debt_rate(creditDto.getDebt_rate())
                .build();
    }
}