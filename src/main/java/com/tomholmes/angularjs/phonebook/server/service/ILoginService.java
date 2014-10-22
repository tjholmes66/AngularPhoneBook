package com.tomholmes.angularjs.phonebook.server.service;

import com.tomholmes.angularjs.phonebook.domain.UserEntity;

public interface ILoginService
{
    UserEntity login(String username, String password);

    UserEntity loginByEmail(String email);

    UserEntity loginByUsername(String username);
}
