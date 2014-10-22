package com.tomholmes.angularjs.phonebook.server.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomholmes.angularjs.phonebook.domain.PositionEntity;
import com.tomholmes.angularjs.phonebook.domain.UserEntity;

public class UserControllerTests extends BaseControllerTests
{
    public final static String BASE_URL = "http://127.0.0.1:8888/";

    public final static String DATE_FORMAT = "yyyy-MM-dd";

    private final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    private final static Log logger = LogFactory.getLog(UserControllerTests.class);

    // @Autowired
    // private UserController userController;

    private final static int id = 0;
    private final static String email = "tom@tomholmes.new";
    private final static int positionId = 2;
    private final static String firstname = "tom5_new";
    private final static String lastname = "holmes5_new";
    private final static String username = "user5new";
    private final static String password = "pass5new";
    private final static String securityQuestion1 = "question1new";
    private final static String securityQuestion2 = "question2new";
    private final static String securityAnswer1 = "answer1new";
    private final static String securityAnswer2 = "answer2ew";

    private UserEntity createUserEntity()
    {
        UserEntity userEntity = new UserEntity();
        // =============================================
        userEntity.setUserId(id);
        userEntity.setActive(true);
        userEntity.setEmail(email);
        PositionEntity position = new PositionEntity();
        position.setId(positionId);
        position.setActive(true);
        userEntity.setPosition(position);
        userEntity.setFirstname(firstname);
        userEntity.setLastname(lastname);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setSecurityQuestion1(securityQuestion1);
        userEntity.setSecurityAnswer1(securityAnswer1);
        userEntity.setSecurityQuestion2(securityQuestion2);
        userEntity.setSecurityAnswer2(securityAnswer2);
        // =============================================
        return userEntity;
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

    private UserEntity updateUserDto(UserEntity userEntity)
    {
        userEntity.setUserId(updId);
        userEntity.setActive(false);
        userEntity.setEmail(updEmail);
        // ------------------------------------------
        PositionEntity position = new PositionEntity();
        position.setId(updPositionId);
        position.setActive(true);
        userEntity.setPosition(position);
        // ------------------------------------------
        userEntity.setFirstname(updFirstname);
        userEntity.setLastname(updLastname);
        userEntity.setPassword(updPassword);
        userEntity.setSecurityQuestion1(updSecurityQuestion1);
        userEntity.setSecurityAnswer1(updSecurityAnswer1);
        userEntity.setSecurityQuestion2(updSecurityQuestion2);
        userEntity.setSecurityAnswer2(updSecurityAnswer2);
        // ------------------------------------------
        return userEntity;
    }

    /*
    I have the following URIs:

        /users - Returns all users
        /users/user/{id} - Return a specific user
        /users/create/{user} - Add user to db
        /users/update/{user} - Update user
        /users/delete/{id} - Delete User
    */

    @Autowired
    private WebApplicationContext wac;

    public WebApplicationContext getWac()
    {
        return wac;
    }

    public void setWac(WebApplicationContext wac)
    {
        this.wac = wac;
    }

    private MockMvc mockMvc;

    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void setUp()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testMockGetUserByUserId() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/userId/1");
        // .andExpect(status().isOk());
    }

    /*
     * Requires App to be running in order to test.
     * Anything with RestTemplate does need the app to be running.
     */
    // @Test
    public void testGetUserByUserId() throws Exception
    {
        String url = BASE_URL + "/rest/users/userId/1";
        UserEntity oldUserDto = restTemplate.getForObject(url, UserEntity.class);
        System.out.println("=======================================================================");
        System.out.println("testGetUserByUserId: oldUserDto=" + oldUserDto.toString());
        System.out.println("=======================================================================");
    }

    /*
     * Requires App to be running in order to test.
     * Anything with RestTemplate does need the app to be running.
     */
    // @Test
    public void testCreateUser() throws Exception
    {
        UserEntity userEntity = createUserEntity();
        String url = BASE_URL + "/rest/users/create";
        UserEntity newUserDto = restTemplate.postForObject(url, userEntity, UserEntity.class, new Object[]
        {});
        System.out.println("=======================================================================");
        System.out.println("testCreateUser: newUserDto=" + newUserDto.toString());
        System.out.println("=======================================================================");
    }

    /*
     * Requires App to be running in order to test.
     * Anything with RestTemplate does need the app to be running.
     */
    // @Test
    public void testUpdateUser() throws Exception
    {
        String urlGet = BASE_URL + "/rest/users/userId/9";
        UserEntity oldUserDto = restTemplate.getForObject(urlGet, UserEntity.class);
        System.out.println("=======================================================================");
        System.out.println("testUpdateUser: oldUserDto=" + oldUserDto.toString());
        System.out.println("=======================================================================");

        UserEntity userEntity = updateUserDto(oldUserDto);
        HttpEntity<UserEntity> entity = new HttpEntity<UserEntity>(userEntity);

        String urlUpdate = BASE_URL + "/rest/users/update";
        restTemplate.put(urlUpdate, entity, UserEntity.class);

        System.out.println("=======================================================================");
        System.out.println("testUpdateUser: newUserDto=");
        System.out.println("=======================================================================");
    }

    /*
     * Requires App to be running in order to test.
     * Anything with RestTemplate does need the app to be running.
     */
    // @Test
    public void testDeleteUser() throws Exception
    {
        String url = BASE_URL + "/rest/users/delete/10";
        restTemplate.delete(url);
    }

    /*
    @Configuration
    public static class TestConfiguration
    {
        @Bean
        public UserController userController()
        {
            return new UserController();
        }
    }
    */

    // @Test
    public void testUpdateUserJSON() throws Exception
    {
        String urlGet = BASE_URL + "/rest/users/userId/1";
        UserEntity oldUserDto = restTemplate.getForObject(urlGet, UserEntity.class);
        System.out.println("=======================================================================");
        System.out.println("testUpdateUser: oldUserDto=" + oldUserDto.toString());
        System.out.println("=======================================================================");

        UserEntity userEntity = oldUserDto;

        // UserEntity userEntity = updateUserDto(oldUserDto);
        // HttpEntity<UserEntity> entity = new HttpEntity<UserEntity>(userEntity);

        String urlUpdate = BASE_URL + "/rest/users/update";
        // restTemplate.put(urlUpdate, entity, UserEntity.class);

        System.out.println("=======================================================================");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(System.out, userEntity);
        System.out.println("=======================================================================");

        System.out.println("=======================================================================");
        System.out.println("testUpdateUser: newUserDto=");
        System.out.println("=======================================================================");
    }

    // @Test
    public void testUserJSONtoObject() throws IOException, ParseException
    {
        StringBuffer sb = new StringBuffer();

        /*
        sb.append("{");
        sb.append("\"userId\":\"1\"");
        sb.append(",\"username\":\"demo\"");
        sb.append(",\"userFirstName\":\"DemoX\"");
        sb.append(",\"userLastName\":\"DemoX\"");
        sb.append(",\"userEmail\":\"tom@tomholmes.netX\"");
        sb.append(", \"userSecurityQuestion1\":\"Meaning of Life?X\"");
        sb.append(", \"userSecurityAnswer1\":\"42X\"");
        sb.append(", \"userSecurityQuestion2\":\"AAA\"");
        sb.append(" , \"userSecurityAnswer2\":\"BBB\"");
        sb.append(" , \"userBirthDate\":\"1966-11-03\"");
        sb.append(", \"position\":{\"id\":1}");
        sb.append("}");
        */

        /*
        sb.append("{");
        sb.append("\"userId\":1,");
        sb.append("\"userActive\":true,");
        sb.append("\"userPassword\":\"demo1\"");
        sb.append("}");
        */

        sb.append("{");
        sb.append("\"userId\":\"1\"");
        sb.append("}");

        System.out.println("=======================================================================");
        System.out.println("json=" + sb.toString());
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userEntity = mapper.readValue(sb.toString(), UserEntity.class);
        System.out.println("=======================================================================");
        System.out.println("UserEntity=" + userEntity.toString());
        System.out.println("=======================================================================");

        String urlGet = BASE_URL + "/rest/users/userId/1";
        UserEntity oldUserDto = restTemplate.getForObject(urlGet, UserEntity.class);
        System.out.println("=======================================================================");
        System.out.println("testUpdateUser: oldUserDto=" + oldUserDto.toString());
        System.out.println("=======================================================================");

        UserEntity user = oldUserDto;

        String urlUpdate = BASE_URL + "/rest/users/update";
        restTemplate.put(urlUpdate, user, UserEntity.class);

        System.out.println("=======================================================================");
        // System.out.println("testUpdateUser: newUserDto=" + newUserDto.toString());
        System.out.println("=======================================================================");
    }

    // @Test
    public void testRetrieveUserJSON() throws Exception
    {
        String urlGet = BASE_URL + "/rest/users/userId/1";
        UserEntity oldUserDto = restTemplate.getForObject(urlGet, UserEntity.class);
        System.out.println("=======================================================================");
        System.out.println("testRetrieveUserJSON: oldUserDto=" + oldUserDto.toString());
        System.out.println("=======================================================================");
    }

    // @Test
    public void testUserJSONtoObjectNew() throws IOException, ParseException
    {
        StringBuffer sb = new StringBuffer();

        sb.append("{");
        sb.append("\"userId\":1, ");
        sb.append("\"userActive\":true");

        sb.append("\"position\":{");
        sb.append("\"id\":1,");
        sb.append("\"active\":true,");
        sb.append("\"code\":\"ADMIN\",");
        sb.append("\"description\":\"Administrator\"");
        sb.append("},");

        sb.append("\"username\":\"demo\",");
        sb.append("\"password\":\"demoXXX\",");
        sb.append("\"otherPassword\":null, ");
        sb.append("\"userFirstName\":\"DemoXXX\", ");
        sb.append("\"userLastName\":\"DemoXXX\", ");
        sb.append("\"userEmail\":\"tom@tomholmes.netXXX\", ");
        sb.append("\"userSecurityQuestion1\":\"aaaXXX\", ");
        sb.append("\"userSecurityAnswer1\":\"bbbXXX\", ");
        sb.append("\"userSecurityQuestion2\":\"cccXXX\", ");
        sb.append("\"userSecurityAnswer2\":\"dddXXX\", ");
        sb.append("\"userBirthDate\":\"1966-11-02\"");

        sb.append("\"contacts\":[");
        sb.append("{");
        sb.append("\"contactId\":2,");
        sb.append("\"userId\":1, ");
        sb.append("\"prefix\":\"Mr.\", ");
        sb.append("\"firstName\":\"updated_fn\", ");
        sb.append("\"middleName\":\"middle_name\", ");
        sb.append("\"lastName\":\"updated_ln\", ");
        sb.append("\"suffix\":\"Jr.\", ");
        sb.append("\"address1\":\"123 main street\", ");
        sb.append("\"address2\":\"Apt. 456\", ");
        sb.append("\"city\":\"Randolph\", ");
        sb.append("\"state\":\"MA\", ");
        sb.append("\"zip\":\"11111-1234\", ");
        sb.append("\"companyId\":0, ");
        sb.append("\"enteredBy\":1, ");
        sb.append("\"enteredDate\":\"2013-06-21\", ");
        sb.append("\"editedBy\":1, ");
        sb.append("\"editedDate\":\"2013-06-21\", ");
        sb.append("\"birthDate\":\"1966-11-03\", ");
        sb.append("\"emails\":null, ");
        sb.append("\"phones\":null, ");
        sb.append("\"links\":null");
        sb.append("}");
        sb.append("]");

        sb.append("}");

        System.out.println("=======================================================================");
        System.out.println("json=" + sb.toString());
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userEntity = mapper.readValue(sb.toString(), UserEntity.class);
        System.out.println("=======================================================================");
        System.out.println("UserEntity=" + userEntity.toString());
        System.out.println("=======================================================================");
    }
}
