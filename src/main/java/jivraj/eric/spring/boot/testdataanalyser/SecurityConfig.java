package jivraj.eric.spring.boot.testdataanalyser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class holds and determines the security configuration of the web application
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception
  {
    httpSecurity.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
  }
}
