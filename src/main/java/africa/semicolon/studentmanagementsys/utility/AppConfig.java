package africa.semicolon.studentmanagementsys.utility;

import africa.semicolon.studentmanagementsys.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    static StudentRepository studentRepository;
    @Bean
    public ModelMapper returnMapper(){
        return new ModelMapper();
    }

//    public static StudentDto map(Student savedStudent, StudentDto studentDto){
//        studentDto.setEmail(savedStudent.getEmail());
//        studentDto.setStudentId(generateStudentId(savedStudent.getStudentId()));
//        return studentDto;
//    }
//    public static Student map(StudentRequest studentRequest, Student student){
//        student.setFirstName(studentRequest.getFirstName());
//        student.setLastName(studentRequest.getLastName());
//        student.setEmail(studentRequest.getEmail());
//        student.setPassword(studentRequest.getPassword());
//        student.setDepartment(studentRequest.getDepartment());
//        student.setCourses(studentRequest.getCourses());
//        return student;
//    }


}
