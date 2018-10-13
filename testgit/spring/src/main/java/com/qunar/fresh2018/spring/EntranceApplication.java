package com.qunar.fresh2018.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication @Controller public class EntranceApplication extends SpringBootServletInitializer {

    @RequestMapping("/") public String index() {

        return "redirect:user/list";
    }

    @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(EntranceApplication.class);
        return builder;
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(EntranceApplication.class);
        builder.run(args);
        // SpringApplication.run(EntranceApplication.class);

    }
}
