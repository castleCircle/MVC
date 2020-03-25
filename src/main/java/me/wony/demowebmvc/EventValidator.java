package me.wony.demowebmvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        //어떤 클래스의 벨리데이션을 지원할꺼냐
        return Event.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Event event = (Event)o;
        if(event.getName().equalsIgnoreCase("aaa")){
            errors.rejectValue("name","wrongValue","the value is not allowed");
        }
    }
}
