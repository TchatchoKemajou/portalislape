package com.empereur.security.Security;

import com.empereur.security.JsonWebToken.JwtTokenFilter;
import com.empereur.security.Repository.GuardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;


@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private JwtTokenFilter jwtTokenFilter;


    @Autowired
    private GuardRepository guardRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(
                username -> guardRepository.findByguardUserName(username)
                        .orElseThrow(
                                () -> new UsernameNotFoundException("User " + username + " not found.")));
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.csrf().disable();
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.authorizeRequests()
//                    .antMatchers("/api/v1/etudiant/allstudent", "/api/v1/employee/*", "/api/v1/site/*").hasRole("ADMIN")
//                    .antMatchers("/api/v1/visite/*", "/api/v1/visiteur/*").hasRole("USER")
                    .antMatchers("/api/v1/auth/login", "/api/v1/gardien/addGuard", "/api/v1/site/addSite")
                    .permitAll()
                    .anyRequest()
                    .authenticated();
            http.exceptionHandling()
                    .authenticationEntryPoint(
                            (request, response, ex) -> {
                                response.sendError(
                                        HttpServletResponse.SC_UNAUTHORIZED,
                                        ex.getMessage()
                                );
                            }
                    );

            http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
//            http.cors().and().csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers("/users")
//                    .hasRole("managers")
//                    .anyRequest()
//                    .authenticated()
//                    .and()
//                    .formLogin();
        }
}
