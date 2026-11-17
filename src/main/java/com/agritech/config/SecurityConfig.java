package com.agritech.config;
import org.springframework.context.annotation.*; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.config.annotation.web.configuration.*; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration @EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 @Bean public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Override protected void configure(HttpSecurity http)throws Exception{http.csrf().disable().authorizeRequests().antMatchers("/","/login","/assets/**","/weather/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/dashboard",true).permitAll().and().logout().logoutSuccessUrl("/login?logout").permitAll();}
 @Override protected void configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder auth)throws Exception{auth.inMemoryAuthentication().withUser("farmer").password(passwordEncoder().encode("Farm@123")).roles("FARMER").and().withUser("admin").password(passwordEncoder().encode("Admin@123")).roles("ADMIN");}
}