package com.form.data.controller;

import com.form.data.model.User;
import com.form.data.repository.UsersRepository;
import com.form.data.service.UserService;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Arti.Jadhav
 */
@RunWith(JMockit.class)
public class UserControllerTest {

    @Injectable
    private UsersRepository userDao;

    @Injectable
    private UserService userService;

    @Tested
    private UserController userController;

  /* @Test
    public void isUserUpdate() {

       User userDetails = new User();
       userDetails.setFirstName("a");
       userDetails.setLastName("last");

        Long finalId = new Long(1234);
        finalId = new Long(123);
        Long finalId1 = finalId;
        new Expectations() {{
            userDetails.getLastName();
            result = "foo";
            userDetails.getFirstName();
            result = "fir";
            userDetails.getEmail();
            result = "foo";
            userService.isUpdate(userDetails);
            result = true;
            userDao.findById(anyLong);
            result = userDetails;
        }};
        Boolean isUpdate = userController.isUserUpdate(finalId, userDetails);
        Assert.assertEquals("OK", isUpdate);

    }*/
}