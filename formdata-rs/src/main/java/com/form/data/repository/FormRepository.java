package com.form.data.repository;

import com.form.data.model.FormData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arti.Jadhav
 */
@Repository
public interface FormRepository extends JpaRepository<FormData, Long> {
}
