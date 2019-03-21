package com.vcors.demo.servicea;

import org.springframework.stereotype.Service;

@Service
public class BServiceFallback implements BService {
    @Override
    public String findById(String id) {
        return "fall back error message";
    }
}
