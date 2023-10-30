package com.sbb.flexrate.security;

import com.sbb.flexrate.member.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/*
Spring Security는 유저 인증 과정에서 UserDetails를 참조하여 인증 진행
Member가 바로 UserDetails 상속 시 엔티티 오염 위험
 */
public class CustomUserDetails implements UserDetails {

    private final Member member;

    public CustomUserDetails(Member member){
        this.member=member;
    }

    public final Member getMember(){
        return member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return member.getRoles().stream().map(o->new SimpleGrantedAuthority(
                o.getName()
        )).collect(Collectors.toList());
    }

    @Override
    public String getPassword(){
        return member.getPassword();
    }

    @Override
    public String getUsername(){
        return member.getAccount();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

}
