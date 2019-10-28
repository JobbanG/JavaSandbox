package dev.sandbox.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ValidatedControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getTestDataReturnsWithSuccess() throws Exception {
        mvc.perform(get("/validated?firstParameter=ss&secondParameter=3&thirdParameter=ABCDE"))
                .andExpect(status().isOk());
    }

    @Test
    public void getTestDataReturnsWithBadRequest() throws Exception {
        mvc.perform(get("/validated?firstParameter=ss&secondParameter=3&thirdParameter=ABCD"))
                .andExpect(status().isBadRequest());
    }

}
