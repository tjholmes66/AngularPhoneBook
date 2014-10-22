package com.tomholmes.angularjs.phonebook.server.dao;

import java.util.List;

import com.tomholmes.angularjs.phonebook.domain.ContactEntity;
import com.tomholmes.angularjs.phonebook.domain.ContactPhoneEntity;

public interface ContactPhoneDao
{

    public ContactPhoneEntity saveContactPhoneEntity(ContactPhoneEntity contactPhone);

    public ContactPhoneEntity createContactPhoneEntity(ContactPhoneEntity contactPhone);

    public ContactPhoneEntity updateContactPhoneEntity(ContactPhoneEntity contactPhone);

    public void deleteContactPhoneEntity(Long contactPhoneId);

    public void deleteContactPhoneEntity(ContactPhoneEntity contactPhone);

    public List<ContactPhoneEntity> getAllContactPhoneEntitys();

    // Retrieve
    public ContactPhoneEntity getContactPhoneEntity(long id);

    public List<ContactPhoneEntity> getContactPhoneEntity(ContactPhoneEntity exampleEntity);

    public List<ContactPhoneEntity> getContactPhoneEntityByContact(ContactEntity exampleContactEntity);

    public List<ContactPhoneEntity> getContactPhoneEntityByContactId(long contactId);

}
