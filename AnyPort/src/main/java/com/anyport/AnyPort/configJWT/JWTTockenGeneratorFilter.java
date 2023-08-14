package com.anyport.AnyPort.configJWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;


public class JWTTockenGeneratorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//        When all authentication steps are done then this authentication object is not null and
//        this filter invoke  before giving response to user.

//        If user provide wrong password or user name then it will be null;
//        This filter fetch from context
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication !=null){
            SecretKey secretKey= Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());  //created a key

            String jwt= Jwts.builder().
                    setIssuer("Raj")
                    .setSubject("Jwt tocken")  //these two are optional
                    .claim("username",authentication.getName())

//    It call method  ===> populateAuthorities <====  which return a string with comma seprated eg=> ADMIN,CUSTOMER,RIDER
                    .claim("role",populateAuthorities(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime()+300000000))
                    .signWith(secretKey).compact();

            response.setHeader(SecurityConstants.JWT_HEADER,jwt);
                    ;

        }
        else{

        }

    }

    private String populateAuthorities(Collection< ? extends GrantedAuthority>  collection){
        String role="";
        for(GrantedAuthority auth:collection){
           role=auth.getAuthority();
        }
        return role;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{

        return !request.getServletPath().equals("/signIn");
    }
}
