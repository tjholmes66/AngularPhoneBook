package com.tomholmes.angularjs.phonebook.server.service;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tomholmes.angularjs.phonebook.domain.UserEntity;

public class LoginServiceImplTest extends BaseServiceImplTests
{

    private static final Log logger = LogFactory.getLog(LoginServiceImplTest.class);

    @Autowired
    private ILoginService service;

    @org.junit.Before
    public void setUp() throws Exception
    {
        System.out.println("setUp: service: " + service);
    }

    @org.junit.After
    public void tearDown()
    {
        service = null;
        System.out.println("tearDown: context set null.");
    }

    @Test
    public void testFetchByLogin() throws Exception
    {
        String username = "demo";
        String password = "demo";
        // ==================================================
        UserEntity user = service.login(username, password);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    @Test
    public void testFetchByEmail() throws Exception
    {
        String email = "tom@tomholmes.net";
        // ==================================================
        UserEntity user = service.loginByEmail(email);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    @Test
    public void testFetchByUsername() throws Exception
    {
        String username = "demo";
        // ==================================================
        UserEntity user = service.loginByUsername(username);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

}
