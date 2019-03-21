package com.vcors.demo.servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.*;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    private MyConfig myConfig;

    @Autowired
    private BService bService;

    @Autowired
    private Environment environment;

    @GetMapping("/config")
    public String testConfig() {

        return myConfig.getPa() + ":" + myConfig.getPb();
    }

    @GetMapping("/secret")
    public String testSecret() {

        return myConfig.getPs();
    }

    @GetMapping("/callb")
    public String testCallB() {
        return bService.findById("hi");
    }

    @GetMapping("/e")
    public String env() {
        Map<String, Object> map = new HashMap();
        for(Iterator<PropertySource<?>> it = ((AbstractEnvironment) environment).getPropertySources().iterator(); it.hasNext(); ) {
            PropertySource<?> propertySource = (PropertySource<?>) it.next();
            if (propertySource instanceof CompositePropertySource) {
                for(Iterator<PropertySource<?>> it2 = ((CompositePropertySource) propertySource).getPropertySources().iterator(); it2.hasNext(); ) {
                    PropertySource<?> propertySource2 = (PropertySource<?>) it2.next();
                    if (propertySource2 instanceof ResourcePropertySource) {
                        for (Map.Entry<String, Object> entry : ((ResourcePropertySource)propertySource2).getSource().entrySet()) {
                            if (entry.getValue() instanceof String) {
                                System.out.println(entry.getKey() + "=" + (String)entry.getValue());
                            }
                        }
                    }
                }
            }
        }
        return "over";
    }
}
