package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloController {

    //GET
    //URI - /hello
    @GetMapping(path = "/hello")
    public String helloworld() {
        return "Hello World";
    }

    @GetMapping(path="/hello-bean")
    public HelloWorldBean helloworldBean() {
        return new HelloWorldBean("Hello Bean");
    }

    @GetMapping(path="/hello-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPath(@PathVariable String name) {
        //throw new RuntimeException("Error has occurred");
        return  new HelloWorldBean(String.format(("Hello World , %s"), name));
    }
}
