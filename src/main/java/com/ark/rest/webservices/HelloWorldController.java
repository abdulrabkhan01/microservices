package com.ark.rest.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
   //@RequestMapping(method = RequestMethod.GET, path = "sayhello")
    @GetMapping(path="hi")
    public String sayHello() {

        return "hello world rest 1.0 !!!!";
    }

    @GetMapping(path="hello")
    public HelloWorld sayHelloWorld() {

        return new HelloWorld("hello world rest 1.0 !!!!");
    }


    @GetMapping(path="hello/pathvar/{varname}")
    public String sayHelloWorldWithPathVar(@PathVariable String varname) {

        return "Hello World pathvar{} "+varname;
    }

    @GetMapping(path="hello/pathvar/{varname}/pathvar2/{newvar}")
    public String sayHelloWorldWith2PathVar(@PathVariable String varname,@PathVariable String newvar) {

        return "Hello World pathvar{} "+varname+" other var{} "+newvar;
    }

    @GetMapping(path ="hello2")
    public String newHello() {
        return "this is test hello from helloworldcontroller";
    }

}
