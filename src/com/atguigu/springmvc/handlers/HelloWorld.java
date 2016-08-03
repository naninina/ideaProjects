package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorld {

    private static final String SUCCESS = "success";

    @RequestMapping(value = "/testParam",method = RequestMethod.GET)//不好意思必须是DELETE,否则通不过的
    public String testParam(@RequestParam(value = "username",required = false,defaultValue = "hello") String str,@RequestParam(value = "age") Integer age){
        System.out.println("username:"+str);
        System.out.println("age:"+age);
        System.out.println("helo");
        return SUCCESS;
    }

   @RequestMapping(value = "/testDelete/{id}",method = RequestMethod.DELETE)//不好意思必须是DELETE,否则通不过的
    public String testDelete(@PathVariable("id") Integer id){
        System.out.println("delete:"+id);
        return SUCCESS;
    }


    @RequestMapping("/testPathVariable/{id}")
    public String testPathVarianble(@PathVariable("id") Integer id){
        System.out.println(id);
        return SUCCESS;
    }

    @RequestMapping("/testAnt/*/a")
    public String testAntpath(){
        System.out.println("testAnt");
        return SUCCESS;
    }

    @RequestMapping(value = "/helloworld",method = RequestMethod.GET)
    public String hello() {


        return "success";
    }
}
