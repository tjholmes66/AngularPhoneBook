package com.tomholmes.angularjs.phonebook.server.dao;

import java.util.List;

import com.tomholmes.angularjs.phonebook.domain.ContactEntity;
import com.tomholmes.angularjs.phonebook.domain.UserEntity;

public interface ContactDao
{

    ContactEntity createContactEntity(ContactEntity contactEntity);

    ContactEntity updateContactEntity(ContactEntity contactEntity);

    void deleteContactEntity(long contactId);

    void deleteContactEntity(ContactEntity contactEntity);

    List<ContactEntity> getAllContactEntitys();

    ContactEntity getContactEntity(long id);

    List<ContactEntity> getContactEntityByUser(UserEntity exampleEntity);

    List<ContactEntity> getContactEntity(ContactEntity exampleEntity);

}
