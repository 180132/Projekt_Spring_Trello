package com.trello.tests;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.support.XmlWebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" )
public class TableControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
    	XmlWebApplicationContext context = new XmlWebApplicationContext();
		//context.setConfigLocations("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml");
        mockMvc = MockMvcBuilders.standaloneSetup(context).build();
    }

    @Test
    public void testViewTables() throws Exception {
		mockMvc.perform(get("/addTable"))
            .andExpect(status().isOk());
            //.andExpect(forwardedUrl("WEB-INF/pages/tableList.jsp"))
            //.andExpect(model().attributeExists("tables"));
    }
}

