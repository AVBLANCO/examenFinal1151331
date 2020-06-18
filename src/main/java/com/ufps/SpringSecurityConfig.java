package com.ufps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.ufps.handler.LoginSuccessHandler;
import com.ufps.service.JpaUserDetailsService;
import javax.sql.DataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import org.springframework.context.annotation.Bean;


@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	    DataSource dataSource;
	@Autowired
	private LoginSuccessHandler successHandler;

	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {


		http.authorizeRequests()
        .antMatchers("/","/login","/index","/registro","/css/**", "/js/**").permitAll()
        .antMatchers("/guest").hasAnyRole("ADMIN")
        .antMatchers("/admin").hasAnyRole("ADMIN")
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/login").permitAll()
        .and().logout()
        .invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?logout");

}
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select usuario as username, password, enabled" + " from usuario" + " where usuario=?")
                .authoritiesByUsernameQuery("select username, authority " + "from authorities " + "where username = ? ");
                
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
  
}
