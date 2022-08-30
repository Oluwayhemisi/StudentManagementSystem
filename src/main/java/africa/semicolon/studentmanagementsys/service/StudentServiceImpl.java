package africa.semicolon.studentmanagementsys.service;

import africa.semicolon.studentmanagementsys.dtos.StudentDto;
import africa.semicolon.studentmanagementsys.dtos.StudentRequest;
import africa.semicolon.studentmanagementsys.dtos.UpdateRequest;
import africa.semicolon.studentmanagementsys.exceptions.SmsException;
import africa.semicolon.studentmanagementsys.models.Student;
import africa.semicolon.studentmanagementsys.repositories.CourseRepository;
import africa.semicolon.studentmanagementsys.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public StudentDto createStudentAccount(StudentRequest studentRequest) throws SmsException {
      validate(studentRequest.getEmail());
      Student student = modelMapper.map(studentRequest, Student.class);
      student.setStudentId(generateStudentId());

      Student savedStudent = studentRepository.save(student);


      log.info("this is the id: {}", savedStudent.getStudentId());
      return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDto updateStudentDetails(String studentId, String email, UpdateRequest updateRequest) throws SmsException {

        Student student = studentRepository.findByStudentId(studentId).orElseThrow(()->new SmsException("Student id not found",404));
        if(student.getFirstName().length() > 0){
            student.setFirstName(updateRequest.getFirstName());
        }
        if(student.getLastName().length() > 0){
            student.setLastName(updateRequest.getLastName());
        }
        if(student.getPassword().length() > 0) {
            student.setPassword(updateRequest.getPassword());
        }
        validate(email);
       student.setEmail(updateRequest.getEmail());
     Student savedStudent =   studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);

    }

    @Override
    public Student findStudentByEmail(String email) throws SmsException {
         return studentRepository.findByEmail(email).orElseThrow(()-> new SmsException("Student email not found",404));
    }

    @Override
    public StudentDto findByStudentId(String studentId) throws SmsException {
        Student student = studentRepository.findByStudentId(studentId).orElseThrow(()-> new SmsException("studentId not found",404));
        return modelMapper.map(student, StudentDto.class);
    }

    private void validate(String email) throws SmsException{
    Optional<Student> student = studentRepository.findByEmail(email);
    if(student.isPresent()){
        throw new SmsException("Email already exist",404);
    }
    }

    private String generateStudentId(){
        int number = studentRepository.findAll().size();
        String id = String.format("%02d",number+1);
        return "ST"+id;
    }

}
