package africa.semicolon.studentmanagementsys.service;

import africa.semicolon.studentmanagementsys.dtos.StudentDto;

import africa.semicolon.studentmanagementsys.dtos.StudentRequest;
import africa.semicolon.studentmanagementsys.dtos.UpdateRequest;
import africa.semicolon.studentmanagementsys.exceptions.SmsException;
import africa.semicolon.studentmanagementsys.models.Courses;
import africa.semicolon.studentmanagementsys.models.Student;
import africa.semicolon.studentmanagementsys.models.enums.Department;
import africa.semicolon.studentmanagementsys.models.enums.Gender;
import africa.semicolon.studentmanagementsys.models.enums.Subjects;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testToCreateStudentAccount() throws SmsException {
     StudentDto studentDto =   createStudent();
        assertEquals("ST01", studentDto.getStudentId());
        assertEquals(1,studentService.getAllStudents().size());

//        Adding the second student account

        StudentRequest studentRequest2 = new StudentRequest();
        studentRequest2.setFirstName("Obafemi");
        studentRequest2.setLastName("Johnson");
        studentRequest2.setEmail("oba@gmail.com");
        studentRequest2.setPassword("1234");
        studentRequest2.setGender(Gender.MALE);
        studentRequest2.setDepartment(Department.ART);

        List<Courses> courses = new ArrayList<>();
        Courses firstCourse = new Courses(Subjects.GOVERNMENT);
        Courses secondCourse = new Courses(Subjects.ENGLISH);

        courses.add(firstCourse);
        courses.add(secondCourse);

        studentRequest2.setCourses(courses);

        StudentDto studentDto1 =  studentService.createStudentAccount(studentRequest2);
        assertEquals("ST02",studentDto1.getStudentId());
        assertEquals(2,studentService.getAllStudents().size());


    }

    private StudentDto createStudent() throws SmsException {
       StudentRequest studentRequest = new StudentRequest();
        studentRequest.setFirstName("Tiara");
        studentRequest.setLastName("Oluwafemi");
        studentRequest.setEmail("tiara@gmail.com");
        studentRequest.setPassword("1111");
        studentRequest.setGender(Gender.FEMALE);
        studentRequest.setDepartment(Department.SCIENCES);

        List<Courses> courses = new ArrayList<>();
        Courses firstCourse = new Courses(Subjects.COMPUTER_SCIENCE);
        Courses secondCourse = new Courses(Subjects.PHYSICS);

        courses.add(firstCourse);
        courses.add(secondCourse);

        studentRequest.setCourses(courses);

        return studentService.createStudentAccount(studentRequest);
    }

    @Test
    public void testThatYouCanUpdateStudentDetails() throws SmsException {


        createStudent();
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setFirstName("Tiara");
        updateRequest.setLastName("Oluwafemi");
        updateRequest.setEmail("Tiara@gmail.com");
        updateRequest.setPassword("0000");
        StudentDto studentDto = studentService.updateStudentDetails("ST01", "teemama@gmail.com",updateRequest);
        assertEquals("0000",updateRequest.getPassword());
        

    }
    @Test
    public void testThatYouCanFindStudentByEmail() throws SmsException{
        createStudent();
        Student student = studentService.findStudentByEmail("tiara@gmail.com");
        assertEquals("tiara@gmail.com",student.getEmail());
    }

    @Test
    public void testThatYouCanFindStudentByStudentId() throws SmsException{
        createStudent();
        StudentDto studentDto = studentService.findByStudentId("ST01");
        assertEquals("ST01",studentDto.getStudentId());

    }
}