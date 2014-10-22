package com.tomholmes.angularjs.phonebook.server.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomholmes.angularjs.phonebook.domain.ContactEntity;
import com.tomholmes.angularjs.phonebook.domain.UserEntity;

public class ContactControllerTests extends BaseControllerTests
{
    public final static String BASE_URL = "http://127.0.0.1:8888/";

    public final static String DATE_FORMAT = "yyyy-MM-dd";

    private final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    private final static Log logger = LogFactory.getLog(ContactControllerTests.class);

    private final static int contactId = 0;
    // =============================================
    private final static String prefix = "Mr.";
    private final static String firstName = "contact_fn1";
    private final static String middleName = "contact_mn1";
    private final static String lastName = "contact_ln1";
    private final static String suffix = "Jr.";
    // =============================================
    private final static String address1 = "123 Main Street";
    private final static String address2 = "Apartment 38A";
    private final static String city = "Boston";
    private final static String state = "MA";
    private final static String zip = "02368-1234";
    // =============================================
    private final static int editedBy = 1;
    private final static Date editedDate = new Date();
    private final static int enteredBy = 1;
    private final static Date enteredDate = new Date();
    // =============================================
    private final static int companyId = 0;
    private final static Date birthDate = new Date();

    // =============================================

    private ContactEntity createContactEntity()
    {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // =============================================
        contactEntity.setPrefix(prefix);
        contactEntity.setFirstName(firstName);
        contactEntity.setMiddleName(middleName);
        contactEntity.setLastName(lastName);
        contactEntity.setSuffix(suffix);
        // =============================================
        contactEntity.setAddress1(address1);
        contactEntity.setAddress2(address2);
        contactEntity.setCity(city);
        contactEntity.setState(state);
        contactEntity.setZip(zip);
        // =============================================
        contactEntity.setCompanyId(companyId);
        contactEntity.setBirthDate(birthDate);
        // =============================================
        contactEntity.setEditedBy(editedBy);
        contactEntity.setEditedDate(editedDate);
        contactEntity.setEnteredBy(enteredBy);
        contactEntity.setEnteredDate(enteredDate);
        // =============================================
        // contactEntity.setEmails(emails)
        // contactEntity.setPhones(phones)
        // contactEntity.setLinks(links)
        // =============================================
        long userId = 1;
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        // =============================================
        contactEntity.setUser(user);
        // =============================================
        return contactEntity;
    }

    private final static int updId = 9;
    private final static String updEmail = "tom@tomholmes.new";
    private final static int updPositionId = 3;
    private final static String updFirstname = "tom4_upd";
    private final static String updLastname = "holmes4_upd";
    private final static String updPassword = "pass4upd";
    private final static String updSecurityQuestion1 = "question1upd";
    private final static String updSecurityQuestion2 = "question2upd";
    private final static String updSecurityAnswer1 = "answer1upd";
    private final static String updSecurityAnswer2 = "answer2upd";

    /*
    private ContactEntity updateContactDto(ContactEntity userDto)
    {
        userDto.setContactId(updId);
        userDto.setContactActive(false);
        userDto.setContactEmail(updEmail);
        // ------------------------------------------
        PositionDTO position = new PositionDTO();
        position.setId(updPositionId);
        position.setActive(true);
        userDto.setPosition(position);
        // ------------------------------------------
        userDto.setContactFirstName(updFirstname);
        userDto.setContactLastName(updLastname);
        userDto.setPassword(updPassword);
        userDto.setContactSecurityQuestion1(updSecurityQuestion1);
        userDto.setContactSecurityAnswer1(updSecurityAnswer1);
        userDto.setContactSecurityQuestion2(updSecurityQuestion2);
        userDto.setContactSecurityAnswer2(updSecurityAnswer2);
        // ------------------------------------------
        return userDto;
    }
    */

    /*
    I have the following URIs:

        /contacts - Returns all contacts
        /contacts/contact/{id} - Return a specific user
        /contacts/create/{user} - Add user to db
        /contacts/update/{user} - Update user
        /contacts/delete/{id} - Delete Contact
    */

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void setUp()
    {
        this.mockMvc = webAppContextSetup(ctx).build();
    }

    // @Test
    public void testMockGetContactByContactId() throws Exception
    {
        mockMvc.perform(get("/contacts/userId/1"));
        // .andExpect(status().isOk());
    }

    /*
     * Requires App to be running in order to test.
     * Anything with RestTemplate does need the app to be running.
     */
    @Test
    public void testGetContactByContactId() throws Exception
    {
        String url = BASE_URL + "/rest/contacts/contactId/2";
        ContactEntity oldContactDto = restTemplate.getForObject(url, ContactEntity.class);
        System.out.println("=======================================================================");
        System.out.println("testGetContactByContactId: oldContactDto=" + oldContactDto.toString());
        System.out.println("=======================================================================");
    }

    /*
     * Requires App to be running in order to test.
     * Anything with RestTemplate does need the app to be running.
     */
    // @Test
    public void testCreateContact() throws Exception
    {
        ContactEntity userDto = createContactEntity();
        String url = BASE_URL + "/rest/contacts/create";
        ContactEntity newContactDto = restTemplate.postForObject(url, userDto, ContactEntity.class, new Object[]
        {});
        System.out.println("=======================================================================");
        System.out.println("testCreateContact: newContactDto=" + newContactDto.toString());
        System.out.println("=======================================================================");
    }

    /*
     * Requires App to be running in order to test.
     * Anything with RestTemplate does need the app to be running.
     */
    // @Test
    public void testUpdateContact() throws Exception
    {
        String urlGet = BASE_URL + "/rest/contacts/userId/9";
        ContactEntity oldContactDto = restTemplate.getForObject(urlGet, ContactEntity.class);
        System.out.println("=======================================================================");
        System.out.println("testUpdateContact: oldContactDto=" + oldContactDto.toString());
        System.out.println("=======================================================================");

        // ContactEntity userDto = updateContactDto(oldContactDto);

        ContactEntity userDto = null;
        HttpEntity<ContactEntity> entity = new HttpEntity<ContactEntity>(userDto);

        String urlUpdate = BASE_URL + "/rest/contacts/update";
        restTemplate.put(urlUpdate, entity, ContactEntity.class);

        System.out.println("=======================================================================");
        System.out.println("testUpdateContact: newContactDto=");
        System.out.println("=======================================================================");
    }

    /*
     * Requires App to be running in order to test.
     * Anything with RestTemplate does need the app to be running.
     */
    // @Test
    public void testDeleteContact() throws Exception
    {
        String url = BASE_URL + "/rest/contacts/delete/10";
        restTemplate.delete(url);
    }

    @Configuration
    public static class TestConfiguration
    {
        @Bean
        public ContactController userController()
        {
            return new ContactController();
        }
    }

    // @Test
    public void testUpdateContactJSON() throws Exception
    {
        String urlGet = BASE_URL + "/rest/contacts/userId/1";
        ContactEntity oldContactDto = restTemplate.getForObject(urlGet, ContactEntity.class);
        System.out.println("=======================================================================");
        System.out.println("testUpdateContact: oldContactDto=" + oldContactDto.toString());
        System.out.println("=======================================================================");

        ContactEntity userDto = oldContactDto;

        // ContactEntity userDto = updateContactDto(oldContactDto);
        // HttpEntity<ContactEntity> entity = new HttpEntity<ContactEntity>(userDto);

        String urlUpdate = BASE_URL + "/rest/contacts/update";
        // restTemplate.put(urlUpdate, entity, ContactEntity.class);

        System.out.println("=======================================================================");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(System.out, userDto);
        System.out.println("=======================================================================");

        System.out.println("=======================================================================");
        System.out.println("testUpdateContact: newContactDto=");
        System.out.println("=======================================================================");
    }

    @Test
    public void testContactJSONtoObject() throws IOException, ParseException
    {
        StringBuffer sb = new StringBuffer();

        /*
        sb.append("{");
        sb.append("\"contactId\":0,");
        sb.append("\"userId\":1,");
        sb.append("\"prefix\":\"Mr.\",");
        sb.append("\"firstName\":\"fn\",");
        sb.append("\"middleName\":\"mn\",");
        sb.append("\"lastName\":\"ln\",");
        sb.append("\"suffix\":\"Jr.\", ");
        sb.append("\"address1\":\"123 Main Street\",");
        sb.append("\"address2\":\"Apt 34\",");
        sb.append("\"city\":\"Boston\",");
        sb.append("\"state\":\"MA\",");
        sb.append("\"zip\":\"12345-1234\",");
        sb.append("\"enteredBy\":1,");
        sb.append("\"editedBy\":1,");
        sb.append("\"enteredDate\":\"2013-06-12T19:17:24\",");
        sb.append("\"editedDate\":\"2013-06-12T19:17:24\",");
        sb.append("\"birthDate\":\"2013-06-12T16:00:00\",");
        sb.append("\"companyId\":0");
        sb.append("}");
        */

        sb.append("{");
        sb.append("\"contactId\":2,");
        sb.append("\"userId\":1,");
        sb.append("\"prefix\":\"Mr.\",");
        sb.append("\"firstName\":\"updated_fnX\",");
        sb.append("\"middleName\":\"middle_nameX\",");
        sb.append("\"lastName\":\"updated_lnX\",");
        sb.append("\"suffix\":\"Jr.\",");
        sb.append("\"address1\":\"123 main streetX\",");
        sb.append("\"address2\":\"Apt. 456X\",");
        sb.append("\"city\":\"RandolphX\",");
        sb.append("\"state\":\"MA\",");
        sb.append("\"zip\":\"11111-1234\",");
        sb.append("\"enteredBy\":1,");
        sb.append("\"editedBy\":1,");
        sb.append("\"enteredDate\":\"2013-06-19T17:59:45\",");
        sb.append("\"editedDate\":\"2013-06-19T17:59:45\",");
        sb.append("\"birthDate\":\"1966-11-03T17:00:00\",");
        sb.append("\"companyId\":0");
        sb.append("}");

        ObjectMapper mapper = new ObjectMapper();

        System.out.println("*=====================================================================*");
        System.out.println("json=" + sb.toString());

        ContactEntity userDto = mapper.readValue(sb.toString(), ContactEntity.class);
        System.out.println("*=====================================================================*");
        System.out.println("ContactEntity=" + userDto.toString());
        System.out.println("*=====================================================================*");

        String urlGet = BASE_URL + "/rest/contacts/contactId/2";
        ContactEntity oldContactDto = restTemplate.getForObject(urlGet, ContactEntity.class);
        System.out.println("=======================================================================");
        System.out.println("testUpdateContact: oldContactDto=" + oldContactDto.toString());
        System.out.println("=======================================================================");
        System.out.println("HERE ==================================================================");
        System.out.println(mapper.writeValueAsString(oldContactDto));
        System.out.println(sb.toString());
        System.out.println("HERE ==================================================================");

        ContactEntity user = oldContactDto;

        String urlUpdate = BASE_URL + "/rest/contacts/update";
        restTemplate.put(urlUpdate, user, ContactEntity.class);

        System.out.println("=======================================================================");
        // System.out.println("testUpdateContact: newContactDto=" + newContactDto.toString());
        System.out.println("=======================================================================");
    }

    @Test
    public void testRetrieveContactJSON() throws Exception
    {
        String urlGet = BASE_URL + "/rest/contacts/contactId/2";
        ContactEntity oldContactDto = restTemplate.getForObject(urlGet, ContactEntity.class);
        System.out.println("=======================================================================");
        System.out.println("testRetrieveContactJSON: oldContactDto=" + oldContactDto.toString());
        System.out.println("=======================================================================");
    }

}
