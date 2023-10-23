package com.cgi.FoodieGatewayMicroservice.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String authHeader = req.getHeader("Authorization");

		if(req.getMethod().equals("OPTIONS")) {

			res.setStatus(HttpStatus.OK.value());
			chain.doFilter(req, res);
		} else if(authHeader == null || !authHeader.startsWith("Bearer ")) {

			throw new ServletException();
		}
		String token = authHeader.split(" ")[1];
		System.out.println(token);
		String claim = "";
		Claims claims = Jwts.parser()
				.setSigningKey("cgicanada")
				.parseClaimsJws(token)
				.getBody();
		claim = claims.getSubject();

		req.setAttribute("claim",claim );
		chain.doFilter(req, res);		

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
