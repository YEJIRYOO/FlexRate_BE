package com.sbb.flexrate.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {

    private Long id;

    private String account;

    private String nickname;

    private String name;

    private String email;

    private Date birth;

    private Boolean gender;

    private String phonenumber;

    private String address;

    private List<Authority> roles=new ArrayList<>();

    private String token;

    public SignResponse(Member member){
        this.id=member.getId();
        this.account=member.getAccount();
        this.address=member.getAddress();
        this.birth=member.getBirth();
        this.nickname=member.getNickname();
        this.name=member.getName();
        this.email=member.getEmail();
        this.phonenumber=member.getPhonenumber();
        this.gender=member.getGender();
        this.roles=member.getRoles();
    }
}