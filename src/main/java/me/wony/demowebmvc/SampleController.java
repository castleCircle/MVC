package me.wony.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class SampleController {

//    @RequestMapping(value = "/hello" , method = {RequestMethod.GET,RequestMethod.PUT})
    @RequestMapping({"/hello/**","/hi","/hi.*"})
    @ResponseBody
    public String hello(){
        return "hello sungwon";
    }

}