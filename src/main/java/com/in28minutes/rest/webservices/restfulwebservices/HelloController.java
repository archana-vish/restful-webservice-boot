package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //GET
    //URI - /hello
    @GetMapping(path = "/hello")
    public String helloworld() {
        return "Hello World";
    }
}
