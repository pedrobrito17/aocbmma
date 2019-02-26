package br.com.aocbmma.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/files/**").permitAll()
                .antMatchers("/font/**").permitAll()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/sisaocbmma/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .antMatchers("/files/**").permitAll()
                // .antMatchers("/sisaocbmma/**").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/sisaocbmma/login").usernameParameter("username").passwordParameter("password").permitAll();
                // .and()
                // .logout().logoutUrl("/sisaocbmma/logout").permitAll();

        httpSecurity.csrf().disable();
        // httpSecurity.headers().frameOptions().disable();
    }

    


}