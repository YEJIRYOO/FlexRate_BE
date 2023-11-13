package com.sbb.flexrate.member;

import java.util.Date;
import java.util.List;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.domain.Loan;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy ="member",cascade = CascadeType.ALL) //변경사항 모두 반영
    private Credit credit;

    @OneToOne(mappedBy = "member",cascade = CascadeType.ALL)
    private Loan loan;

    @Column(unique = true)
    private String account; //토큰 Service 통해 자동 발급

    private String password;

    private String nickname;

    private String name;

    private Date birth;

    private Boolean gender;

    private String phonenumber;

    private String address;

    @Column(unique = true)
    private String email;

    //fetch_속성 데이터 어떻게 로드 할 지_즉시 로드
    //Lazy: 실제로 데이터에 접근할 때까지 로드하지 않음
    @OneToMany(mappedBy = "member",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Builder.Default//빌더 패턴 생성
    private List<Authority> roles=new ArrayList<>();

    public void setRoles(List<Authority> role){
        this.roles=role;
        role.forEach(o -> o.setMember(this));
        //Authority 엔터티 순회하며 setMember 메서드 호출
    }
}

/*
사용자: 아이디, account, 비밀번호, 닉네임, 이름, 이메일, 권한(목록)
 */