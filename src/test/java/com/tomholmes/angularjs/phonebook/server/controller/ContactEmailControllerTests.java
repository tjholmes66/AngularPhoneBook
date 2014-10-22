package com.tomholmes.angularjs.phonebook.server.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

public class ContactEmailControllerTests extends BaseControllerTests
{
    private final static Log logger = LogFactory.getLog(ContactEmailControllerTests.class);

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void setUp()
    {
        this.mockMvc = webAppContextSetup(ctx).build();
    }

    @Test
    public void testGetContactEmails()
    {
        assertEquals(true, true);
    }
}
