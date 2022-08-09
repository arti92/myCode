package com.form.data.controller;

import com.form.data.exception.ResourceNotFoundException;
import com.form.data.model.User;
import com.form.data.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Arti.Jadhav
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UsersRepository userRepository;

    @GetMapping("/Users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/Users")
    public User createUser(@RequestBody User User) {
        return userRepository.save(User);
    }

    @GetMapping("/Users/{id}")
    public User getUserById(@PathVariable(value = "id") Long UserId) {
        return userRepository.findById(UserId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", UserId));
    }

    @PutMapping("/Users/{id}")
    public User updateUser(@PathVariable(value = "id") Long UserId, @RequestBody User userDetails) {

        User user = userRepository.findById(UserId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", UserId));

        user.setFirstName(userDetails.getFirstName());
        user.setEmail(userDetails.getEmail());
        user.setLastName(userDetails.getLastName());
        user.setPassword(userDetails.getPassword());
        user.setActive(userDetails.isActive());
        if (userDetails.isActive() == null) {
            user.setActive(true);
        }


        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    //TODO: Soft delete
    @DeleteMapping("/Users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long UserId) {
        User User = userRepository.findById(UserId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", UserId));

        userRepository.delete(User);

        return ResponseEntity.ok().build();
    }
}
