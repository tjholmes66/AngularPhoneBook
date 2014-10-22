package com.tomholmes.angularjs.phonebook.server.dao;

import java.util.List;

import com.tomholmes.angularjs.phonebook.domain.LinkTypeEntity;

public interface LinkTypeDao
{

    public LinkTypeEntity saveLinkTypeEntity(LinkTypeEntity linkType);

    public void deleteLinkTypeEntity(Long linkTypeId);

    public void deleteLinkTypeEntity(LinkTypeEntity linkType);

    public List<LinkTypeEntity> getAllLinkTypeEntitys();

    // Retrieve
    public LinkTypeEntity getLinkTypeEntity(long id);

    public List<LinkTypeEntity> getLinkTypeEntity(LinkTypeEntity exampleEntity);

}