package com.tomholmes.angularjs.phonebook.server.service;

import java.util.List;

import com.tomholmes.angularjs.phonebook.domain.ContactEmailEntity;
import com.tomholmes.angularjs.phonebook.domain.ContactEntity;

public interface IContactEmailService
{
    List<ContactEmailEntity> getAllEmailsByContactId(long contactId);

    ContactEmailEntity getEmailContactById(long emailId);

    List<ContactEmailEntity> getAllEmailsByContactId(ContactEntity contactEntity);

}
