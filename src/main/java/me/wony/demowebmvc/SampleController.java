package me.wony.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@SessionAttributes("event")
public class SampleController {

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model, HttpSession httpSession){
        model.addAttribute("event",new Event());
        return "/events/form-name";
    }


    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Validated @ModelAttribute Event event,
                              BindingResult bindingResult)                              {
        if(bindingResult.hasErrors()){
            return "/events/form-name";
        }
        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event ,  Model model){
        model.addAttribute("event",event);
        return "/events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsFormLimitSubmit(@Validated @ModelAttribute Event event,
                                 BindingResult bindingResult,
                                        SessionStatus sessionStatus)                              {
        if(bindingResult.hasErrors()){
            return "/events/form-limit";
        }
        sessionStatus.setComplete();
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model , @SessionAttribute LocalDateTime visitTime){
        System.out.println(visitTime);
        Event event = new Event();
        event.setName("srping");
        event.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute(eventList);
        return "/events/list";
    }


//    @PostMapping("/events")
//    @ResponseBody
//    public Event getEvent(@Validated(Event.ValidateLimit.class) @ModelAttribute Event event , BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            System.out.println("====================");
//            bindingResult.getAllErrors().forEach(c->{
//                System.out.println(c.toString());
//            });
//        }
//
//        return event;
//    }



}
