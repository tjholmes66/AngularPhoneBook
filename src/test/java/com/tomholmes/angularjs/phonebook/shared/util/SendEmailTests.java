package com.tomholmes.angularjs.phonebook.shared.util;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations =
{ "classpath*:applicationContext.xml" })
public class SendEmailTests
{
    private final static Log logger = LogFactory.getLog(SendEmailTests.class);

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    private ISendEmailService service;

    @Test
    public void testSendEmail()
    {

        // MailMail mm = (MailMail) context.getBean("mailMail");

        service.sendMail("duncan20s@msn.com", "tom@tomholmes.net", "Testing123",
            "Testing only \n\n Hello Spring Email Sender");

        assertEquals(true, true);
    }
}
