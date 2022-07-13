package com.company.monthandmathservice.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.company.monthandmathservice.models.MonthsConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.bind.annotation.RequestMethod.*;


class MonthsConverterControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
    @Before
    public void setUp(){}
    @Test
    public void shouldReturnRecordByNumber() throws Exception {
        // ARRANGE
        MonthsConverter MonthsConverter = new MonthsConverter();
        MonthsConverter.setName("January");
        MonthsConverter.setNumber(1);
        String outputJson = mapper.writeValueAsString(MonthsConverter);
        // ACT
        mockMvc.perform(get("/months/1"))
                    .andDo(print())
                    .andExpect(status().isOk())                     // ASSERT that we got back 200 OK.
                    .andExpect((ResultMatcher) content().json(outputJson));         // ASSERT that what we're expecting is what we got back.
                   }}
