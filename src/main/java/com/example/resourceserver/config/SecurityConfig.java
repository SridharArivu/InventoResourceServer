package com.example.resourceserver.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static String clientID;

    @Value("${env.ISSUER_URI}")
    public String JwkSetUri;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/ping/**","/api/v1/auth/**").permitAll()
                        .anyRequest()
                        .authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));



        return httpSecurity.build();
    }
    @Bean
    public JwtDecoder jwtDecoder(){

        JwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(JwkSetUri).build();

        return new JwtDecoder() {
            @Override
            public Jwt decode(String token) throws JwtException {

                Jwt jwt = jwtDecoder.decode(token);
                clientID = jwt.getSubject();
                return jwt;
            }
        };


    }

}
