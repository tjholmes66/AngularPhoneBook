package com.tomholmes.angularjs.phonebook.server.service;

import java.util.List;

import com.tomholmes.angularjs.phonebook.domain.ContactEntity;

public interface IContactService
{

    List<ContactEntity> getAllContacts();

    List<ContactEntity> getContactsByUserId(long userId);

    ContactEntity getContactById(long contactId);

    ContactEntity add(ContactEntity newContact);

    ContactEntity update(ContactEntity newContact);

    void remove(long contactId);

}
