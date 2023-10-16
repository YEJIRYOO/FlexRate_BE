package com.sbb.flexrate.member;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor
//AllArgsCon~ : 모든 클래스 필드 매개변수로 하는 생성자 자동 생성
//NoArgsCon~ : 매개변수 없는 기본 생성자 자동 생성
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String account;

    private String password;

    private String nickname;

    private String name;

    private Date birth;

    private Character sex;

    private String phonenumber;

    private String address;

    @Column(unique = true)
    private String email;


    @OneToMany(mappedBy = "member",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    //fetch_속성 데이터 어떻게 로드 할 지_즉시 로드
    //Lazy: 실제로 데이터에 접근할 때까지 로드하지 않음
    @Builder.Default//빌더 패턴 생성
    private List<Authority> roles=new ArrayList<>();

    public void setRoles(List<Authority> role){
        this.roles=role;
        role.forEach(o->o.setMember(this));
        //Authority 엔터티 순회하며 setMember 메서드 호출
    }
}

/*
사용자: 아이디, account, 비밀번호, 닉네임, 이름, 이메일, 권한(목록)
 */