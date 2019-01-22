package at.fh.ima.swengs.cineFoxDB;


import at.fh.ima.swengs.cineFoxDB.filter.JwtTokenAuthenticationFilter;
import at.fh.ima.swengs.cineFoxDB.filter.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;


@EnableWebSecurity    // Enable security config. This annotation denotes config for spring security.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // handle an authorized attempts
                .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                // Add a filter to validate user credentials and add token in the response header

                // What's the authenticationManager()?
                // An object provided by WebSecurityConfigurerAdapter, used to authenticate the user passing user's credentials
                // The filter needs this auth manager to authenticate the user.
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))
                .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                // allow all POST requests
                .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
                .antMatchers(HttpMethod.POST, "/dto/user").permitAll()
                .antMatchers(HttpMethod.GET, "/dto/users").permitAll()
                .antMatchers(HttpMethod.GET, "/series").permitAll()
                .antMatchers(HttpMethod.GET, "/genres").permitAll()
                .antMatchers(HttpMethod.GET, "/media/**").permitAll()
                .antMatchers(HttpMethod.GET, "/charakters").permitAll()
                .antMatchers(HttpMethod.GET, "/herstellers").permitAll()
                .antMatchers(HttpMethod.GET, "/kategories").permitAll()
                .antMatchers(HttpMethod.GET, "/persons").permitAll()
                .antMatchers(HttpMethod.GET, "/medias/**").permitAll()
                // must be an admin if trying to access admin area (authentication is also required here)
                .antMatchers("/admin/**").hasRole("ADMIN")
                // any other requests must be authenticated
                .anyRequest().authenticated();
    }

    // Spring has UserDetailsService interface, which can be overriden to provide our implementation for fetching user from database (or any other source).
    // The UserDetailsService object is used by the auth manager to load the user from database.
    // In addition, we need to define the password encoder also. So, auth manager can compare and verify passwords.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
