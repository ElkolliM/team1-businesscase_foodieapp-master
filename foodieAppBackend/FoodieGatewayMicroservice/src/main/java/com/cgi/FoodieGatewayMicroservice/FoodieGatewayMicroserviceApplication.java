package com.cgi.FoodieGatewayMicroservice;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.cgi.FoodieGatewayMicroservice.config.FoodieAppGlobalFilter;
import com.cgi.FoodieGatewayMicroservice.config.HandlerFilter;
import com.cgi.FoodieGatewayMicroservice.config.JWTFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


//import com.cgi.FoodieGatewayMicroservice.config.foodieGlobalFilter;

import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAspectJAutoProxy
public class FoodieGatewayMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodieGatewayMicroserviceApplication.class, args);
	}
	@Bean
	public GlobalFilter getGlobalFilter() {
		return new FoodieAppGlobalFilter();
	}

	@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
		 
		  return builder.routes() 
				  .route((r)->{return  r.path("/api/v1/orders/**").uri("http://localhost:9001");})
				  .route((r)->{return  r.path("/api/v1/dish/**").uri("http://localhost:9002");})
				  .route((r)->{return  r.path("/api/v1/restaurant/**").uri("http://localhost:9003");})
			  .route((r)->{return  r.path("/api/v1/feedbacks/**").uri("http://localhost:8080");}).build();
	}
	
	@Bean
	public CorsWebFilter corsWebFilter() {
	   
	   System.out.println("cors invoked");
	
	    CorsConfiguration corsConfig = new CorsConfiguration();
	    corsConfig.setAllowedOrigins(Arrays.asList("*"));
	    corsConfig.setMaxAge(3600L);
	    corsConfig.setAllowedMethods(Arrays.asList("GET", "POST","PUT","DELETE"));
	    corsConfig.addAllowedHeader("*");
	
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", corsConfig);
	
	    return new CorsWebFilter(source);
	}

		 

}
