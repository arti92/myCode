package com.form.data.repository;

import com.form.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arti.Jadhav
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

}
