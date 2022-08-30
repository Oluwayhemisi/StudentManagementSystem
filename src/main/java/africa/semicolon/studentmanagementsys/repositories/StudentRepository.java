package africa.semicolon.studentmanagementsys.repositories;

import africa.semicolon.studentmanagementsys.dtos.StudentRequest;
import africa.semicolon.studentmanagementsys.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);

    Optional <Student> findByStudentId(String studentId);
}
