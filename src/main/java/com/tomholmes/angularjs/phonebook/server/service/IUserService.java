package com.tomholmes.angularjs.phonebook.server.service;

import java.util.List;

import com.tomholmes.angularjs.phonebook.domain.UserEntity;

public interface IUserService
{
    public List<UserEntity> getAllUsers();

    UserEntity getUserById(long userId);

    UserEntity add(UserEntity userEntity);

    void remove(UserEntity record);

    UserEntity update(UserEntity userEntity);

    void remove(long userId);
}
