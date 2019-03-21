package com.vcors.demo.servicea;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-b", fallback = BServiceFallback.class)
public interface BService {

    @GetMapping("/b/{id}")
    String findById(@PathVariable("id") String id);
}
