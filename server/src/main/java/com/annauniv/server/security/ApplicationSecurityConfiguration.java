package com.annauniv.server.security;

import com.annauniv.server.jwt.JwtConfiguration;
import com.annauniv.server.jwt.JwtTokenVerifier;
import com.annauniv.server.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.crypto.SecretKey;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration {
    private final SecretKey secretKey;
    private final JwtConfiguration jwtConfiguration;

    @Autowired
    public ApplicationSecurityConfiguration(SecretKey secretKey,
                                            JwtConfiguration jwtConfiguration) {
        this.secretKey = secretKey;
        this.jwtConfiguration = jwtConfiguration;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = authenticationManager(http.getSharedObject(AuthenticationConfiguration.class));

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager, jwtConfiguration, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfiguration), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/api/discussions/**").permitAll()
                .anyRequest()
                .authenticated();

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new MvcConfiguration();
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy =
                """
                        create:dean > create:hod
                        create:hod > create:professor
                        create:professor > create:student
                        """;

        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

//    @Bean
//    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
//        var expressionHandler = new DefaultWebSecurityExpressionHandler();
//        expressionHandler.setRoleHierarchy(roleHierarchy());
//        return expressionHandler;
//    }

}
