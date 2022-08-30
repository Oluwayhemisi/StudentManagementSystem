package africa.semicolon.studentmanagementsys.service;

import africa.semicolon.studentmanagementsys.dtos.StudentDto;
import africa.semicolon.studentmanagementsys.dtos.StudentRequest;
import africa.semicolon.studentmanagementsys.dtos.UpdateRequest;
import africa.semicolon.studentmanagementsys.exceptions.SmsException;
import africa.semicolon.studentmanagementsys.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

     StudentDto createStudentAccount(StudentRequest studentRequest) throws SmsException;
     List<Student> getAllStudents();

     StudentDto updateStudentDetails(String studentId, String email, UpdateRequest updateRequest) throws SmsException;
     Student findStudentByEmail(String email) throws SmsException;
     StudentDto findByStudentId(String studentId) throws SmsException;

}

