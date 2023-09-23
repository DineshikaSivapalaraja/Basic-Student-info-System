package com.dineshi.studentinfosystem.repository;

import com.dineshi.studentinfosystem.model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface studentRepository extends JpaRepository<student, Integer> {

}
