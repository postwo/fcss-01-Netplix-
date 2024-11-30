package com.example.fcss_01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    //InMemoryUserDetailsManager를 사용하여 사용자 정보를 메모리에 저장합니다. 예제에서는 danny라는 사용자를 생성하고 비밀번호를 설정
    //메모리 내에 사용자 데이터를 저장하여 인증에 사용할 수 있도록 합니다.
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails danny = User.builder().username("danny").password("password").build();
        inMemoryUserDetailsManager.createUser(danny);

        return inMemoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    //모든 요청을 인증된 사용자만 접근할 수 있도록 설정하고, HTTP 기본 인증을 사용하도록 합니다.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((auth) -> auth.anyRequest().authenticated())
                .httpBasic(withDefaults());
        return httpSecurity.build();
    }
}