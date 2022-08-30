package africa.semicolon.studentmanagementsys.controllers;

import africa.semicolon.studentmanagementsys.controllers.requestsAndResponse.ApiResponse;
import africa.semicolon.studentmanagementsys.dtos.StudentDto;
import africa.semicolon.studentmanagementsys.dtos.StudentRequest;
import africa.semicolon.studentmanagementsys.dtos.UpdateRequest;
import africa.semicolon.studentmanagementsys.exceptions.SmsException;
import africa.semicolon.studentmanagementsys.models.Student;
import africa.semicolon.studentmanagementsys.service.StudentService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createStudentForm(@RequestBody StudentRequest studentRequest){
        try{
            StudentDto studentDto = studentService.createStudentAccount(studentRequest);
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("success")
                    .message("Student created successfully")
                    .data(studentDto)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("failed")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.valueOf(400));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudents(@PathVariable("id") String studentId ){
        try{
            if(("null").equals(studentId) || ("").equals(studentId)){
                throw new SmsException("student id cannot be null",404);
            }
            StudentDto studentDto = studentService.findByStudentId(studentId);
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("success")
                    .message("student found")
                    .data(studentDto)
                    .build();
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }catch (SmsException e){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("fail")
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.valueOf(e.getStatusCode()));
        }
    }

    @PatchMapping("/")
    public  ResponseEntity<?> updateStudentDetails(@Valid @NotNull @NotBlank String studentId,@Valid @NotNull @NotBlank String email, @RequestBody @NotNull UpdateRequest updateRequest){
       try{
           StudentDto studentDto = studentService.updateStudentDetails(studentId,email,updateRequest);
           ApiResponse apiResponse = ApiResponse.builder()
                   .status("success")
                   .message("update successfully")
                   .data(studentDto)
                   .build();
           return new ResponseEntity<>(apiResponse,HttpStatus.OK);
       }catch (SmsException e){
           ApiResponse apiResponse = ApiResponse.builder()
                   .status("fail")
                   .build();
           return new ResponseEntity<>(apiResponse,HttpStatus.valueOf(e.getStatusCode()));
       }
    }
    @GetMapping("/students")
    public ResponseEntity<?> listOfStudent(){
        List<Student> student = studentService.getAllStudents();
        ApiResponse apiResponse = ApiResponse.builder()
                .status("Success")
                .message("user found")
                .result(student.size())
                .build();
        return  new ResponseEntity<>(apiResponse,HttpStatus.FOUND);

    }

}
