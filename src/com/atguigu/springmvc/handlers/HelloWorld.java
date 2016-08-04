package com.atguigu.springmvc.handlers;

import com.atguigu.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

//@SessionAttributes({"u"})
@SessionAttributes(value = {"u"}, types = {String.class})
@Controller
public class HelloWorld {

    private static final String SUCCESS = "success";
    String str = "nihao";

    @ModelAttribute
    public void getUser(@RequestParam("id") Integer id,Map<String,Object> map){
        if (id != null) {
            User user = new User();
            user.setId(id);
            user.setPassword("123");
            user.setEmail("1@qq.com");
            user.setUsername("quan");
            map.put("user", user);
        }


    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println(user);
        return SUCCESS;
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        map.put("u", Arrays.asList("zhangsan", "ls", "ww"));
        map.put("school", "sadasdasdsa");
        return SUCCESS;

    }

    @RequestMapping("/testMap")
    public String testPam(Map<String, Object> map) {
        map.put("names", Arrays.asList("zhangsan", "ls", "ww"));
        return SUCCESS;

    }


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView(SUCCESS);
        modelAndView.addObject("time", new Date());

        return modelAndView;


    }

    @RequestMapping("/testServletApi")
    public void testSetvletApi(HttpServletRequest request, HttpServletResponse response, Writer writer) {
        System.out.println("request:" + request);
        System.out.println("response:" + response);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
        try {
            writer.write("asdasdasdzzhong中国asdsa");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return SUCCESS;

    }

    @RequestMapping(value = "/testPojo", method = RequestMethod.POST)
    public String testPojo(User user) {
        System.out.println(user);
        return SUCCESS;
    }

    @RequestMapping("/123fku")
    public String testRest() {
        System.out.println("hello");

        return SUCCESS;
    }

    @RequestMapping(value = "/testParam", method = RequestMethod.GET)//不好意思必须是DELETE,否则通不过的
    public String testParam(@RequestParam(value = "username", required = false, defaultValue = "hello") String str, @RequestParam(value = "age") Integer age) {
        System.out.println("username:" + str);
        System.out.println("age:" + age);
        System.out.println("hel123o");
        return SUCCESS;
    }

    @RequestMapping(value = "/testDelete/{id}", method = RequestMethod.DELETE)//不好意思必须是DELETE,否则通不过的
    public String testDelete(@PathVariable("id") Integer id) {
        System.out.println("delete:" + id);
        return SUCCESS;
    }


    @RequestMapping("/testPathVariable/{id}")
    public String testPathVarianble(@PathVariable("id") Integer id) {
        System.out.println(id);
        return SUCCESS;
    }

    @RequestMapping("/testAnt/*/a")
    public String testAntpath() {
        System.out.println("testAnt");
        return SUCCESS;
    }

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String hello() {


        return "success";
    }

    public static void main(String[] args) {
        new HelloWorld();
    }
}
