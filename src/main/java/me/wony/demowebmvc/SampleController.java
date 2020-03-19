package me.wony.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class SampleController {

    @GetMapping(value = "/hello" ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE ,produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String hello(){
        return "hello sungwon";
    }

        @RequestMapping(value = "/hello1" , headers = HttpHeaders.FROM , params = "name")
    @ResponseBody
    public String hello1(){
        return "hello sungwon";
    }


    @GetMapping(value = "/hello2")
    @ResponseBody
    public String hello2(){
        return "hello sungwon";
    }

    @PostMapping(value = "/hello2")
    @ResponseBody
    public String hello3(){
        return "hello sungwon";
    }

    @GetHelloMapping
    @ResponseBody
    public String hello4(){
        return "hello";
    }
}
