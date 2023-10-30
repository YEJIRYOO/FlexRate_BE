package com.sbb.flexrate.member;

/*
응답, 반환 이용 DTO
 */

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SignRequest {

    private Long id;

    private String account;

    private String password;

    private String nickname;

    private String name;

    private String email;

    private Date birth;

    private Character sex;

    private String phonenumber;

    private String address;

}
//생년월일
//성별
//휴대폰 번호
//주소
