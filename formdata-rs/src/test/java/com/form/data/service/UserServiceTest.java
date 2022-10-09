package com.form.data.service;

import com.form.data.controller.UserController;
import com.form.data.model.User;
import com.form.data.repository.UsersRepository;
import mockit.Expectations;
import mockit.FullVerifications;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Arti.Jadhav
 */
@RunWith(JMockit.class)
public class UserServiceTest {


    @Injectable
    private UsersRepository userDao;

    @Tested
    private UserService userService;

    @Test
    public void isUser(){
        User user = new User();
        user.setFirstName("a");
        user.setLastName("last");
        new Expectations() {{
            userDao.save(withAny(user)); result = user;
        }};

        Boolean isUser = userService.isUpdate(user);
        System.out.println("isUser:: "+isUser);
        Assert.assertTrue("User id not present ",isUser);
        new FullVerifications(user) {};
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
