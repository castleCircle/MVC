package me.wony.demowebmvc;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Event {

//    interface ValidateLimit {}
//    interface ValidateNme{}

    private Integer id;

    //@NotBlank(groups = ValidateNme.class)
    @NotBlank
    private String name;

//    @Min(value= 0 ,groups = ValidateNme.class )
    @Min(0)
    private Integer limit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
