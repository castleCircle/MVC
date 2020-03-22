package me.wony.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@SessionAttributes("event")
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model, HttpSession httpSession){
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event",new Event());
        //httpSession.setAttribute("event",newEvent);
        //모델에 같은 이름으로 쓰고 있다면 Session에 들어간다.
        return "/events/form";
    }


    @PostMapping("/events")
    public String createEvent(@Validated @ModelAttribute Event event,
                              BindingResult bindingResult,
                              Model model,
                              SessionStatus sessionStatus,
                              HttpSession httpSession){
        if(bindingResult.hasErrors()){
            return "/events/form";
        }

        Event e = (Event)httpSession.getAttribute("event");
        System.out.println("get : " + e.getLimit());

        sessionStatus.setComplete();
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model){
        Event event = new Event();
        event.setName("spring");
        event.setLimit(10);
        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute(eventList);
        return "/event/list";
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
