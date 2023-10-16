package com.sbb.flexrate.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
Filter 적용을 통해 servlet에 도달하기 전에 검증 완료 _ 유효성 검증
OncePerRequestFilter는 단 한번의 요청에 단 한번만 동작하도록 보장된 필터
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;

    public JwtAuthenticationFilter(JwtProvider jwtProvider){
        this.jwtProvider=jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain) throws ServletException,IOException{
        String token=jwtProvider.resolveToken(request);

        if(token!=null&&jwtProvider.validateToken(token)){
            //check access token
            token=token.split(" ")[1].trim();
            Authentication auth=jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request,response);
        //예외처리 불필요
    }
}
