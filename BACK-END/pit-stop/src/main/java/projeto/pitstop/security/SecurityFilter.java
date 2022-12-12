package projeto.pitstop.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class SecurityFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
									HttpServletResponse response, 
									FilterChain filterChain/*OBJETO DO FILTRO*/) 
									throws ServletException, IOException {
	
		//VERIFICA SE TEM (AUTORIZATION) NO HEADER
		if(request.getHeader("Authorization") != null) {
			Authentication auth = TokenUtil.validate(request);
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		//INTERCEPTA REQUISIÇÃO   
		filterChain.doFilter(request, response);
		
	}

} 