package com.trigyn.jpalms.repository;

import com.trigyn.jpalms.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentDetails, Long> {
    List<StudentDetails> findStudentByUserName(String userName);
}
