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
    public User updateUser(@PathVariable(value = "id") Long UserId, @RequestBody User UserDetails) {

        User User = userRepository.findById(UserId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", UserId));

       // User.setPostName(UserDetails.getPostName());
        //User.setUser(UserDetails.getUser());

        User updatedUser = userRepository.save(User);
        return updatedUser;
    }

    @DeleteMapping("/Users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long UserId) {
        User User = userRepository.findById(UserId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", UserId));

        userRepository.delete(User);

        return ResponseEntity.ok().build();
    }
}
