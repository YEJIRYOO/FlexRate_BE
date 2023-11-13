package com.sbb.flexrate.member;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.domain.Loan;
import com.sbb.flexrate.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class SignService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public SignResponse login(SignRequest request) throws Exception {
        Member member = memberRepository.findByAccount(request.getAccount()).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }

        return SignResponse.builder()
                .id(member.getId())
                .account(member.getAccount())
                .address(member.getAddress())
                .birth(member.getBirth())
                .name(member.getName())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .phonenumber(member.getPhonenumber())
                .gender(member.getGender())
                .roles(member.getRoles())
                .token(jwtProvider.createToken(member.getAccount(), member.getRoles()))
                .build();

    }

    public boolean register(SignRequest request) throws Exception {
        try {
            Member member = Member.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name(request.getName())
                    .nickname(request.getNickname())
                    .email(request.getEmail())
                    .address(request.getAddress())
                    .birth(request.getBirth())
                    .phonenumber(request.getPhonenumber())
                    .gender(request.getGender())
                    .build();

            Credit credit=Credit.builder()
                            .member(member)
                                    .build();

            Loan loan=Loan.builder()
                            .member(member)
                    .birth_year(member.getBirth())
                    .gender(member.getGender())
                    .korea_interest_rate(3.5f)
                    .index_pc(1.223714f)
                                    .build();

            member.setLoan(loan);
            member.setCredit(credit);
            member.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));
            memberRepository.save(member);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }

    public SignResponse getMember(String account) throws Exception {
        Member member = memberRepository.findByAccount(account)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new SignResponse(member);
    }

}