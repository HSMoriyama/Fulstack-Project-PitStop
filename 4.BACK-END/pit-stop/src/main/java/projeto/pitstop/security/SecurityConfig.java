package projeto.pitstop.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//INFORMA QUE A CLASSE É DE CONFIGURAÇÃO DO SERVIÇO DE SEGURANÇA 
@Configuration
//TRATA O ACESSO AOS ENDPOINTS
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	public void configure(HttpSecurity httpSec) throws Exception{
		
		//DESABILITA TODOS OS ACESSOS EXTERNOS A API, INFORMANDO QUE AGORA
		//EXISTE UMA FORMA, UMA REGRA PRÓPRIA DE AUTENTIÇÃO.
		httpSec.csrf().disable()
					  //INFORMA QUE O QUE VEM NA LINHA DE BAIXO SERA LIBERADO
					  .authorizeHttpRequests()
					  //LIBERANDO ROTAS DE ACESSO
					  
					  /*USUARIO CONTROLLER*/
					  .antMatchers(HttpMethod.GET, "/user").permitAll()
					  .antMatchers(HttpMethod.PUT, "/user").permitAll()
					  .antMatchers(HttpMethod.POST, "/user").permitAll()
					  .antMatchers(HttpMethod.DELETE, "/user").permitAll()
					  .antMatchers(HttpMethod.POST, "/user/login").permitAll()
					  .antMatchers(HttpMethod.GET, "/user/userbyid").permitAll()
					  
					  /*AGENDAMENTO SERVIÇO CONTROLLER*/
					  .antMatchers(HttpMethod.GET, "/servico").permitAll()
					  .antMatchers(HttpMethod.PUT, "/servico").permitAll()
					  .antMatchers(HttpMethod.POST, "/servico").permitAll()
					  .antMatchers(HttpMethod.DELETE, "/servico").permitAll()
					  .antMatchers(HttpMethod.POST, "/servico/bynome").permitAll()
					  .antMatchers(HttpMethod.GET, "/servico/byidjson").permitAll()					  
					  .antMatchers(HttpMethod.GET, "/servico/byid").permitAll()
					  
					  /*OFICINA CONTROLLER*/
					  .antMatchers(HttpMethod.GET, "/oficina").permitAll()
					  .antMatchers(HttpMethod.PUT, "/oficina").permitAll()
					  .antMatchers(HttpMethod.POST, "/oficina").permitAll()
					  .antMatchers(HttpMethod.DELETE, "/oficina").permitAll()				  
					  .antMatchers(HttpMethod.GET, "/oficina/oficinabyid").permitAll()
					  
					  /*CLIENTE CONTROLLER*/
					  .antMatchers(HttpMethod.GET, "/cliente").permitAll()
					  .antMatchers(HttpMethod.PUT, "/cliente").permitAll()
					  .antMatchers(HttpMethod.POST, "/cliente").permitAll()
					  .antMatchers(HttpMethod.DELETE, "/cliente").permitAll()				  
					  .antMatchers(HttpMethod.GET, "/cliente/clientebyid").permitAll()
					  
					  /*AVALIAÇÃO OFICINA CONTROLLER*/
					  .antMatchers(HttpMethod.GET, "/avaliacao/oficina").permitAll()
					  .antMatchers(HttpMethod.PUT, "/avaliacao/oficina").permitAll()
					  .antMatchers(HttpMethod.POST, "/avaliacao/oficina").permitAll()
					  .antMatchers(HttpMethod.DELETE, "/avaliacao/oficina").permitAll()				  
					  .antMatchers(HttpMethod.GET, "/avaliacao/oficina/avaliacaobyid").permitAll()
					  
					  .anyRequest().authenticated().and().cors();
		
		//ANTES DE PASSAR A REQUISIÇÃO, SERÁ REALIZADO UM FILTRO
		httpSec.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
}
