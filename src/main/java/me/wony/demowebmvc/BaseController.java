package me.wony.demowebmvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice(assignableTypes = {TestController.class,SampleController.class})
public class BaseController {
    @ExceptionHandler
    public String eventErrorHandler(EventException exception, Model model){
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
}
