package com.tomholmes.angularjs.phonebook.server.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomholmes.angularjs.phonebook.domain.UserEntity;
import com.tomholmes.angularjs.phonebook.server.service.ILoginService;
import com.tomholmes.angularjs.phonebook.shared.util.ISendEmailService;

@Controller
@RequestMapping("/login")
public class LoginController
{
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");

    @Autowired
    private ILoginService loginService;

    @Autowired
    private ISendEmailService emailService;

    @RequestMapping(value = "/user/{username}/pwd/{password}", method = RequestMethod.GET)
    public @ResponseBody
    UserEntity login(@PathVariable("username") String username, @PathVariable("password") String password)
    {
        System.out.println("LoginController: login: START: username=" + username + " password=" + password);
        UserEntity userEntity = null;
        if (username != null && (password != null && !password.equals("null")))
        {
            userEntity = loginService.login(username, password);
        }
        else
        {
            userEntity = loginService.loginByUsername(username);
        }
        System.out.println("LoginController: login: FINISH: userEntity=" + userEntity);
        return userEntity;
    }

    @RequestMapping(value = "/email/{email:.*}", method = RequestMethod.GET)
    public @ResponseBody
    UserEntity login(@PathVariable("email") String email)
    {
        System.out.println("LoginController: login: START: email=" + email);

        UserEntity userEntity = loginService.loginByEmail(email);

        if (userEntity != null)
        {
            String msgBody = "Found your username: " + userEntity.getUsername();

            // sendMail(String from, String to, String subject, String msg)

            // emailService.sendMail("phonebook_app@tomholmes.net", userEntity.getEmail(), "Phonebook App - Found Username", msgBody);
        }
        System.out.println("LoginController: login: FINISH: userEntity=" + userEntity);
        return userEntity;
    }

}
