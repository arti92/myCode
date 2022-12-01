package com.form.data.service;

import com.form.data.model.User;
import com.form.data.repository.UsersRepository;
import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Arti.Jadhav
 */
@RunWith(JMockit.class)
public class UserServiceTest2 {

    @Injectable
    private UsersRepository userDao;

    @Tested
    private UserService userService;
/*
    private Mockery mockContext;


    @Before
    public void setup() {
        mockContext = new Mockery() {{
            setImposteriser(ClassImposteriser.INSTANCE);
        }};
    }
    @After
    public void tearDown() {
        mockContext.assertIsSatisfied();
        mockContext = null;
    }*/

    @Test
    public void isUser(@Mocked User user1) {
        User user = new User();
        user.setFirstName("a");
        // user.setLastName("last");

        new Expectations() {{
            userDao.save(withAny(user));
            result = user;
        }};
      /*  new Verifications(){{
            userDao.save(with(user));times =1;

        }};*/
        /*

        Boolean isUser = userService.isUpdate(user);
        System.out.println("isUser:: "+isUser);
        Assert.assertTrue("User id not present ",isUser);
        new FullVerifications(user) {};*/
     /*   mockContext.checking(new Expectations() {{
            allowing(userDao).save(user);
            will(returnValue(user));
        }});*/
        Boolean isUser = userService.isUpdate(user);
        System.out.println("isUser:: " + isUser);
        Assert.assertTrue("User id not present ", isUser);
        new FullVerifications(user) {
        };
    }



/*

    private    User user;
    private UsersRepository usersRepository;

    @Before
    public void setup(){
         user = new User();

        // set up mock to return person object
        usersRepository = context.mock(UsersRepository.class);
        oneOf (dao).getPerson(5); will(returnValue(person));

        // create class under test with mock
        personService = new PersonServiceImpl(dao);
    }

    @Injectable
    private UsersRepository userDao;

    @Tested
    private UserService userService;

    @Test
    public void isUser(){
        UserService userService = new UserService();
    }
*/


}
