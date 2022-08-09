package com.form.data.repository;

import com.form.data.model.FormData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Arti.Jadhav
 */
public interface FormRepository extends JpaRepository<FormData, Long> {
}
