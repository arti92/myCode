package com.form.data.service;

import com.form.data.model.User;
import com.form.data.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arti.Jadhav
 */
@Service
public class UserService {
    @Autowired
    UsersRepository userRepository;

    public Boolean isUpdate(User user) {
        User updatedUser = userRepository.save(user);
        if (updatedUser != null && updatedUser.getLastName() != null && !updatedUser.getLastName().isEmpty())
            return true;
        return false;
    }
}
