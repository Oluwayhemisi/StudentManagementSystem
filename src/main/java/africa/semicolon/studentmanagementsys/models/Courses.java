package africa.semicolon.studentmanagementsys.models;

import africa.semicolon.studentmanagementsys.models.enums.Subjects;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;


@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Enumerated(EnumType.STRING)
    @NonNull
    private Subjects subjects;

//    public Courses(Subjects subjects) {
//        this.subjects = subjects;
//    }

    public Courses() {

    }
}
