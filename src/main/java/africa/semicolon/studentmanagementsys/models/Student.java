package africa.semicolon.studentmanagementsys.models;

import africa.semicolon.studentmanagementsys.models.enums.Department;
import africa.semicolon.studentmanagementsys.models.enums.Gender;
import africa.semicolon.studentmanagementsys.models.enums.Level;
import africa.semicolon.studentmanagementsys.models.enums.Subjects;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.util.List;





@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Validated
@Builder
@Table(name = "students")

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_sequence")
    private Long id;

//    @NotNull
//    @NotBlank
    private String firstName;


//    @NotNull
//    @NotBlank
    private String lastName;

    @Email
    @NotNull
    @Column(unique = true)
    @NotBlank
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Department department;

    @Enumerated(value = EnumType.STRING)
    private Subjects subjects;

    @Enumerated(value = EnumType.ORDINAL)
    private Level level;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Courses> courses;
    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String studentId;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;





}
