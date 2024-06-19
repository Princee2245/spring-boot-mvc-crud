package com.luv2code.demosecurity.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //add support for jdbc
    // table name are authorities and roles so we do not need to write extra code
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        return  new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){


        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve user by username

        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");

        //define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
                .formLogin(form->
                        form
                                .loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout->logout.permitAll()
                        )
                .exceptionHandling(configure->
                       configure.accessDeniedPage("/access-denied") );
        //we have to create controller for showLoginPage but not for authenticateTheUser as it is
        //handel by spring itself
        return http.build();
    }
}

/*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john= User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary=User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan=User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }
    */