    package com.sbb.flexrate.domain;

    import com.sbb.flexrate.domain.Credit;
    import com.sbb.flexrate.dto.LoanCreateRequestDto;
    import com.sbb.flexrate.member.Member;
    import lombok.*;

    import javax.persistence.*;
    import java.util.Date;

    @Getter
    @Setter
    @Entity
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="loan")
    public class Loan {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="loan_id")
        private Long id;

        @OneToOne
        @JoinColumn(name = "member_id")
        private Member member;

        //************member class***********

        @Column
        private Date birth_year;

        @Column
        private Boolean gender;


        //*********credit class from member class***********

        @Column
        private Long yearly_income;
        //연수입

        @Column
        private Long loan_cnt;//이미 대출하고 있는 건 수

        @Column
        private Long loan_amount;//이미 대출하고 있는 금액


        //TODO: credit 어떻게 해야할까 _Credit모델 output

        //*********loan 자체*************
        @Column
        private Long credit_score;

        @Column
        private Boolean personal_rehabilitation_yn;
        //개인 회생자 여부

        @Column
        private Boolean personal_rehabilitation_complete_yn;
        //개인 회생 납부 여부

        @Column
        private Long company_year;//근속연수

        //********상수값 주입***************

        @Column
        private Float korea_interest_rate = 3.5f;//한국 은행 기준 금리_상수: 3.5고정

        @Column
        private Float index_pc = 1.223714f;//거시경제지표 pca_상수: 1.223714고정

        //TODO: 범주형 변수_ 수입유형, 고용형태

        public static Loan from(LoanCreateRequestDto loanDto){
            return Loan.builder()
//                    .birth_year(loanDto.getBirth_year())
//                    .gender(loanDto.getGender())
                    .birth_year(loanDto.getMember().getBirth())
                    .gender(loanDto.getMember().getGender())
                    .yearly_income(loanDto.getYearly_income())
                    .loan_cnt(loanDto.getLoan_cnt())
                    .loan_amount(loanDto.getLoan_amount())
                    .personal_rehabilitation_yn(loanDto.getPersonal_rehabilitation_yn())
                    .personal_rehabilitation_complete_yn(loanDto.getPersonal_rehabilitation_complete_yn())
                    .company_year(loanDto.getCompany_year())
                    .korea_interest_rate(3.5f)
                    .index_pc(1.223714f)
                    .build();
        }
    }

    /*
    금리 엔티티
     */