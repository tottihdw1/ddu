package hdw.org.jwt.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author hdw
 * @create 2020-06-02-15:43
 * @desc 描述
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin")
                .password("$2a$10$ufbuz764gjDyxz/hmWzncupHAPT97nljAm64m81LJidUD.wHzOPla").roles("admin")
                .and()
                .withUser("hdw")
                .password("$2a$10$E0YIfLUdM9DrTwn0KRKKdeXJjxVhEoXs31O4iquz7d2yRBprkEsGG")
                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/hello").hasRole("user")
                .antMatchers("/admin").hasRole("admin")
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtLoginFilter("/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtFilter(),UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }
}