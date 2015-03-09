package com.tomholmes.angularjs.phonebook.server.service;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:/spring/angular-context.xml" })
@Transactional
public class BaseServiceImplTests extends TestCase
{

}
