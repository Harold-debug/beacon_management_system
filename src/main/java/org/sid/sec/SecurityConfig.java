package org.sid.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      /*  auth.inMemoryAuthentication().withUser("admin").roles("ADMIN","USER").password("{noop}1234");
        auth.inMemoryAuthentication().withUser("user").roles("USER").password("{noop}1234");
*/
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
                .authoritiesByUsernameQuery("select username as principal, roles as role from users_roles where username=? ")
                .rolePrefix("ROLE_")
                .passwordEncoder(new MessageDigestPasswordEncoder("MD5"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login");
//        http.authorizeRequests().antMatchers("/**").permitAll();


        http.authorizeRequests().antMatchers("/edit", "/edit/{id}","/baliseDisponible","/page/{pageNo}").hasRole("USER");


        http.authorizeRequests().antMatchers("/createBalise","/delete/{id}").hasRole("ADMIN");
        http.exceptionHandling().accessDeniedPage("/403");
    }
}
