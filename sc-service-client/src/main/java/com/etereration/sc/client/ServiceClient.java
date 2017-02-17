package com.etereration.sc.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("sc-service")
public interface ServiceClient {
    @RequestMapping("/ping")
    String ping();
    @RequestMapping("/message")
    String message();
}