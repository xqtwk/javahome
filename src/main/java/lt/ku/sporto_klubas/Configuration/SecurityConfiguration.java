package lt.ku.sporto_klubas.Configuration;

import lt.ku.sporto_klubas.Services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    ClientsService clientsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder();
        auth
                .userDetailsService(this.clientsService)
                .passwordEncoder(bc);
    }
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/clients/new").permitAll()
                .antMatchers("/clients/*").hasAnyAuthority("admin")
                .antMatchers("/").permitAll()
                .antMatchers("/clients/*").hasAnyAuthority("user","admin")
                .antMatchers("/registrations/*").hasAnyAuthority("user","admin")
                .antMatchers("/workouts/").hasAnyAuthority("user","admin")
                .antMatchers("/workouts/*").hasAnyAuthority("admin")
                .antMatchers("/login*").permitAll()
                .antMatchers("/register*").permitAll()
                .anyRequest().authenticated()

        .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .failureUrl("/login-error")
        .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
