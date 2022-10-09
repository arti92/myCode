package com.form.data.controller;

import com.form.data.model.User;
import com.form.data.repository.UsersRepository;
import com.form.data.service.UserService;
import mockit.*;
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
    public void isUserUpdate(@Mocked Long id, @Mocked User userDetails) {


        Long finalId = id;
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
        new FullVerifications(userService) {
        };
        new FullVerifications(userDetails) {
        };
    }*/
}