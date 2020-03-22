package me.wony.demowebmvc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void eventForm() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/events/form"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void helloTest() throws  Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/events?name=sungwon")
        .param("name","sungwon").param("limit","-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }




}
