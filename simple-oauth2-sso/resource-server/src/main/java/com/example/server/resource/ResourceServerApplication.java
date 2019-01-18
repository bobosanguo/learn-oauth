package com.example.server.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ResourceServerApplication {
    /**
     * 供client获取用户详情
     * @param principal
     * @return
     */
    @RequestMapping({ "/me" })
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap();
        map.put("name", principal.getName());
        // 自定义detail
        map.put("test", "test");
        return map;
    }

    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApplication.class, args);
    }

}

