package com.tomholmes.angularjs.phonebook.server.dao;

import java.util.List;

import com.tomholmes.angularjs.phonebook.domain.ContactEmailEntity;
import com.tomholmes.angularjs.phonebook.domain.ContactEntity;

public interface ContactEmailDao
{

    public ContactEmailEntity saveContactEmailEntity(ContactEmailEntity contactEmail);

    public ContactEmailEntity createContactEmailEntity(ContactEmailEntity contactEmail);

    public ContactEmailEntity updateContactEmailEntity(ContactEmailEntity contactEmail);

    public void deleteContactEmailEntity(Long contactEmailId);

    public void deleteContactEmailEntity(ContactEmailEntity contactEmail);

    public List<ContactEmailEntity> getAllContactEmailEntitys();

    // Retrieve
    public ContactEmailEntity getContactEmailEntity(long id);

    public List<ContactEmailEntity> getContactEmailEntity(ContactEmailEntity exampleEntity);

    public List<ContactEmailEntity> getContactEmailEntityByContact(ContactEntity exampleContactEntity);

    public List<ContactEmailEntity> getContactEmailEntityByContactId(long contactId);

}
