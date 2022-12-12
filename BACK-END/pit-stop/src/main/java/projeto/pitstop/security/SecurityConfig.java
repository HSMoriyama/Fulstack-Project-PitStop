package projeto.pitstop.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//INFORMA QUE A CLASSE É DE CONFIGURAÇÃO DO SERVIÇO DE SEGURANÇA 
//@Configuration
//TRATA O ACESSO AOS ENDPOINTS
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	public void configure(HttpSecurity httpSec) throws Exception{
		
		//DESABILITA TODOS OS ACESSOS EXTERNOS A API, INFORMANDO QUE AGORA
		//EXISTE UMA FORMA, UMA REGRA PRÓPRIA DE AUTENTIÇÃO.
		httpSec.csrf().disable()
					  //INFORMA QUE O QUE VEM NA LINHA DE BAIXO SERA LIBERADO
					  .authorizeHttpRequests()
					  //LIBERANDO ROTA DE ACESSO
					  .antMatchers(HttpMethod.POST, "/user").permitAll()
					  .antMatchers(HttpMethod.POST, "/user/login").permitAll()
					  .anyRequest().authenticated().and().cors();
		
		//ANTES DE PASSAR A REQUISIÇÃO, SERÁ REALIZADO UM FILTRO
		httpSec.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
	*/
}
