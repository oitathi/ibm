package br.com.volks.rota2030.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import br.com.volks.rota2030.service.AutenticacaoService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	//autenticacao 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService);
	}
	
	// autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		  http.authorizeRequests()
		  .antMatchers(HttpMethod.POST,"/auth").permitAll()
		  .antMatchers(HttpMethod.GET,"/item-de-seguranca/lista-itens").permitAll()
		  .antMatchers(HttpMethod.GET,"/item-de-seguranca/lista-itens/*").permitAll()
		  .anyRequest().authenticated()
		  .and().csrf().disable()
		  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
		
		
		http.authorizeRequests().antMatchers("/").permitAll()
        .and()
        .authorizeRequests().antMatchers("/h2-console/**").permitAll()
        .and()
        .headers().frameOptions().disable()
        .and()
        .csrf().ignoringAntMatchers("/h2-console/**")
        .and()
        .cors().disable();
	}
	
	//recursos estaticos
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
}
