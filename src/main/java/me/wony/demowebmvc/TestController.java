package me.wony.demowebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TestController {

//    @Autowired
//    EventValidator eventValidator;


    //여러개 있을경우 가장 구체적인 것으로 잡힘힘
   @ExceptionHandler
    public String eventErrorHandler(EventException exception,Model model){
        model.addAttribute("message","event error");
        return "error"; //error.jsp
    }

    @ExceptionHandler({EventException.class,RuntimeException.class})
    public String eventErrorHandler(RuntimeException exception,Model model){
        model.addAttribute("message","Runtimeexcpetion error");
        return "error"; //error.jsp
    }


    //핸들러들이 값으 바인딩할때 추가할수있는 것이다.
    @InitBinder
    public void initEventBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
        webDataBinder.addValidators(new EventValidator());
    }

    //모든 핸들러들이 공통으로 사용할 모델
    @ModelAttribute
    public void sub(Model model){
        model.addAttribute("subjects", List.of("ss","aa"));
        throw new EventException();
    }


    @GetMapping("/aa")
    public String test(Model model, HttpSession httpSession){
        if(model.asMap().get("subjects")!=null){
            System.out.println("gd");
        }
        return "redirect:/bb";
    }


    @GetMapping("/bb")
    @ResponseBody
    public String test1(Model model , HttpSession httpSession){
        if(model.asMap().get("subjects")!=null){
            System.out.println("gd");
        }
        return "redirect:/bb";
    }

    @PostMapping("/cc")
    public String test2(Model model , HttpSession httpSession, BindingResult bindingResult){
        //validator에 의해 걸림
        if(bindingResult.hasErrors()){
            return "/events/~~~";
        }

        //명시적도 가능
        //eventValidator.validate(event,eventValidator);

       return "redirect:/bb";
    }
}
