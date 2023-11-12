package com.sbb.flexrate.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.sbb.flexrate.domain.Credit;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore //JSON 형식 직렬화 할 때 무시
    private Long id;

    private String name;

    @JoinColumn(name = "member")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Member member;

//    @JoinColumn(name = "credit_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Credit credit;

    public void setMember(Member member){
        this.member=member;
    }
//    public void setCredit(Credit credit){this.credit=credit;}
}