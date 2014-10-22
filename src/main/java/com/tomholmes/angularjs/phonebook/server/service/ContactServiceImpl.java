package com.tomholmes.angularjs.phonebook.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.angularjs.phonebook.domain.ContactEntity;
import com.tomholmes.angularjs.phonebook.domain.UserEntity;
import com.tomholmes.angularjs.phonebook.server.dao.ContactDao;

@Transactional
@Service("contactService")
public class ContactServiceImpl implements IContactService
{
    @Autowired
    private ContactDao contactDao;

    @Override
    public List<ContactEntity> getAllContacts()
    {
        List<ContactEntity> contactList = contactDao.getAllContactEntitys();
        return contactList;
    }

    @Override
    public List<ContactEntity> getContactsByUserId(long userId)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        List<ContactEntity> contactList = contactDao.getContactEntityByUser(userEntity);
        return contactList;
    }

    @Override
    public ContactEntity getContactById(long contactId)
    {
        ContactEntity contactEntity = contactDao.getContactEntity(contactId);
        return contactEntity;
    }

    @Override
    public ContactEntity add(ContactEntity newContact)
    {
        ContactEntity contactEntity = contactDao.createContactEntity(newContact);
        return contactEntity;
    }

    @Override
    public ContactEntity update(ContactEntity newContact)
    {
        ContactEntity updatedContactEntity = contactDao.updateContactEntity(newContact);
        return updatedContactEntity;
    }

    @Override
    public void remove(long contactId)
    {
        System.out.println("remove: contactId=" + contactId);
        contactDao.deleteContactEntity(contactId);
    }
}
