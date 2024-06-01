package com.microservice.departmentservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.microservice.departmentservice.client.EmpClient;

@Configuration
public class WebclientConfig {
	
	@Autowired
	private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    WebClient employeeWebClient() {
		return WebClient.builder().baseUrl("http://employee-service")
				.filter(filterFunction).build();	
	}
	
    @Bean
    EmpClient empClient() {
    	HttpServiceProxyFactory httpproxy = HttpServiceProxyFactory.
    			builder(WebClientAdapter.forClient(employeeWebClient())).build();
		return httpproxy.createClient(EmpClient.class);
    }
	

}
