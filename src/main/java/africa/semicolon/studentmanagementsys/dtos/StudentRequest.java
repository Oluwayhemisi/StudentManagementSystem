package africa.semicolon.studentmanagementsys.dtos;

import africa.semicolon.studentmanagementsys.models.Courses;
import africa.semicolon.studentmanagementsys.models.enums.Department;
import africa.semicolon.studentmanagementsys.models.enums.Gender;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Department department;
    private List<Courses> courses;
    private Gender gender;


    @Override
    public String toString() {
        return "StudentRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", department=" + department +
                ", courses=" + courses +
                '}';
    }
}
