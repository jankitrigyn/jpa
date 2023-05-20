package com.trigyn.jpalms.service;

import com.trigyn.jpalms.entity.StudentDetails;
import com.trigyn.jpalms.model.BookVO;
import com.trigyn.jpalms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<BookVO> getAllStudentDetails(){
        List<BookVO> bookStudentList = new ArrayList<>();
        for(StudentDetails studentDetails : studentRepository.findAll()){
            bookStudentList.add(convertStudentVO(studentDetails));
        }
        return bookStudentList;
    }

    private BookVO convertStudentVO(StudentDetails studentDetails){
        BookVO bookVO = new BookVO();
        bookVO.setId(studentDetails.getId());
        bookVO.setUserName(studentDetails.getUserName());
        bookVO.setBookName(studentDetails.getBookName());
        bookVO.setFine(studentDetails.getFine());
        bookVO.setPeriod(studentDetails.getPeriod());
        bookVO.setIssueDate(studentDetails.getIssueDate());
        bookVO.setReturnDate(studentDetails.getReturnDate());
        return bookVO;
    }

    public Boolean saveStudent(BookVO bookVO){
        StudentDetails studentDetails = convertStudentEntity(bookVO);
        try {
            studentRepository.save(studentDetails);
            return true;
        }catch (Exception e){
            System.out.printf("Exception during the save the data in db");
            e.printStackTrace();
            return false;
        }
    }

    private StudentDetails convertStudentEntity(BookVO bookVO) {
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(bookVO.getId());
        studentDetails.setUserName(bookVO.getUserName());
        studentDetails.setBookName(bookVO.getBookName());
        studentDetails.setFine(bookVO.getFine());
        studentDetails.setPeriod(bookVO.getPeriod());
        studentDetails.setIssueDate(bookVO.getIssueDate());
        studentDetails.setReturnDate(bookVO.getReturnDate());
        return studentDetails;
    }

    public List<BookVO> findStudentByUserName(String userName){
        List<BookVO> bookVOList = new ArrayList<>();
        List<StudentDetails> studentDetails = studentRepository.findStudentByUserName(userName);
        for(StudentDetails student : studentDetails){
            bookVOList.add(convertStudentVO(student));
        }
        return bookVOList;
    }
}
