package com.etereration.sc.client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@EnableCircuitBreaker
public class SCClientApplication {

    
    @Autowired
    private ServiceClient serviceClient;
    
    private static final Logger LOG = Logger.getLogger(SCClientApplication.class.getName());
    public static void main(String[] args) {
        SpringApplication.run(SCClientApplication.class, args);
    }
 
    
    @Bean
    public AlwaysSampler defaultSampler() {
      return new AlwaysSampler();
    }
    
	@HystrixCommand(fallbackMethod = "pingFallback")
    @RequestMapping("/greeting")
    public String greeting() {
        return "greeting =>"+ serviceClient.ping();
    }
    
	public String pingFallback() {
		return "greeting => fallback";
	}
	
	
	@HystrixCommand(fallbackMethod = "helloFallback")
    @RequestMapping("/hello")
    public String hello() {
        return "me =>"+ serviceClient.message();
    }
    
	public String helloFallback() {
		return "hello => fallback";
	}
    
  
}