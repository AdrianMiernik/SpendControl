//package pl.miernik.spendcontroller.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.sql.DataSource;
//
//@Configuration
//@RequiredArgsConstructor
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final DataSource dataSource;
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    //Authentication
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("SELECT username, password FROM users WHERE username = ?")
//                .authoritiesByUsernameQuery("SELECT u.username, r.name FROM users u JOIN users_roles ur " +
//                        "ON u.id = ur.user_id JOIN roles r ON r.id= ur.roles_id WHERE u.username = ?");
//    }
//
//    //Authorization
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/registration").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/settings/**").hasRole("ADMIN")
//                .antMatchers("/income/**").authenticated()
//                .antMatchers("/balance/**").authenticated()
//                .antMatchers("/expense/**").authenticated()
//                .and().formLogin().loginPage("/login").permitAll()
//                .and().logout().logoutUrl("/logout").permitAll()
//                .logoutSuccessUrl("/login")
//                .permitAll()
//                .and().exceptionHandling().accessDeniedPage("/403");
//        //create 403 html
//    }
//
//}
//
