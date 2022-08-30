package africa.semicolon.studentmanagementsys.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto implements Serializable {
    private Long id;
    private String email;
    private String StudentId;
}
