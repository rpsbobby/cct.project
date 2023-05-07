package ca.dss.csd.cct.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    // documentation available at : https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter#ldap-authentication

    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(config -> config
                        .requestMatchers("/css/style.css").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/newUserForm").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/signup").permitAll()
                        .requestMatchers("/error/access-denied").permitAll()
                        .requestMatchers("/data/**").hasAuthority("USER")
                        .requestMatchers("/api/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/authenticate").permitAll().defaultSuccessUrl("/data/getAll"))
                .logout(LogoutConfigurer::permitAll);
        return security.build();
    }
}
