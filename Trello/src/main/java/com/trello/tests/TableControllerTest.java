package com.trello.tests;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class TableControllerTest {

    private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext wac;
    
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).dispatchOptions(true).build();
    }

    @Test
    public void testviewTables() throws Exception {
    	MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/viewTables");
		ResultActions result = mockMvc.perform(request);
		result.andExpect(status().isOk());
		result.andExpect(model().attributeExists("tables"));
    }
}

