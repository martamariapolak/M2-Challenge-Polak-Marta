package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.models.MathSolution;
import com.company.monthandmathservice.models.MonthsConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
    }

    @Test
    public void shouldReturnError422() throws Exception {
        // ARRANGE
        MathSolution math = new MathSolution();
        math.setOperand1(1);
        math.setOperand2(1);
        math.setOperation("kkk");
        math.setAnswer();
        String outputJson = mapper.writeValueAsString(math);
        // ACT
        mockMvc.perform(

                        post("/add")                                // Perform the POST request.
                                .content(outputJson)                               // Set the request body.
                                .contentType(MediaType.APPLICATION_JSON)          // Tell the server it's in JSON format.
                )
                .andDo(print())                                           // Print results to console.
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422ForNumbers() throws Exception {
        // ARRANGE

        Map<String, String> input = new HashMap<>();
        input.put("operand1", "8");
        input.put("operand2", "this is a string not a number");

        String outputJson = mapper.writeValueAsString(input);
        // ACT
        mockMvc.perform(

                        post("/add")                                // Perform the POST request.
                                .content(outputJson)                               // Set the request body.
                                .contentType(MediaType.APPLICATION_JSON)          // Tell the server it's in JSON format.
                )
                .andDo(print())                                           // Print results to console.
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422For0Division() throws Exception {
        // ARRANGE
        MathSolution math = new MathSolution();
        math.setOperand1(4);
        math.setOperand2(0);
        math.setOperation("divide");
        math.setAnswer();
        String outputJson = mapper.writeValueAsString(math);
        // ACT
        mockMvc.perform(

                        post("/divide")                                // Perform the POST request.
                                .content(outputJson)                               // Set the request body.
                                .contentType(MediaType.APPLICATION_JSON)          // Tell the server it's in JSON format.
                )
                .andDo(print())                                        // Print results to console.
                                                         // Print results to console.
                .andExpect(status().isUnprocessableEntity());

    }


    @Test
    public void shouldReturnRecordByNumber() throws Exception {
        // ARRANGE
        MathSolution math = new MathSolution();
        ;
        math.setOperand1(8);
        math.setOperand2(4);
        math.setOperation("divide");
        //math.setAnswer();
        String outputJson = mapper.writeValueAsString(math);
        // ACT
        mockMvc.perform(
                post("/divide")
                        .content(outputJson)                               // Set the request body.
                        .contentType(MediaType.APPLICATION_JSON)          // Tell the server it's in JSON format.
                )
                .andDo(print())                                        // Print results to console.
                // Print results to console.
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) content().json(outputJson));
        // ASSERT that what we're expecting is what we got back.
    }
}

