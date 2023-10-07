package br.com.towerise.inbound.rest.filters;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityFilter implements Filter {
	
	@Value("${keycloak.introspect.url}")
	private String keycloakIntrospectUrl;
	
	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		log.info("Inicializando filtro SecurityFilter");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
		if(permiteAcesso(request.getRequestURI())) {
			filterChain.doFilter(request, response);
			return;
		}

		var token = request.getHeader("Authorization");
		if (token == null) {
			log.warn("Token não encontrado!");
			response.sendError(401);
			return;
		} 
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		var httpEntity = new HttpEntity<>(headers);

		try {
			var restTemplate = new RestTemplate();
			restTemplate.exchange(keycloakIntrospectUrl, HttpMethod.POST, httpEntity, String.class);
		} catch (HttpClientErrorException e) {
			log.warn("Falha ao validar o token: {}", e.getMessage());
			response.sendError(401);
			return;
		}
			
		filterChain.doFilter(request, response);
	}
	
	/**
	 * Verifica se a URI solicitada é aberta
	 * @param path
	 * @return boolean
	 */
	private boolean permiteAcesso(String path) {
		List<String> paths = List.of("");
		return paths.stream().anyMatch(p -> p.equalsIgnoreCase(path));
	}
	
	@Override
	public void destroy() {
		log.warn("Finalizando filtro SecurityFilter");
	}

}