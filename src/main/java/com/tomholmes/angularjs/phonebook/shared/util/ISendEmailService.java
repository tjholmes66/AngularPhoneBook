package com.tomholmes.angularjs.phonebook.shared.util;

public interface ISendEmailService
{

    void sendMail(String from, String to, String subject, String msg);

}
