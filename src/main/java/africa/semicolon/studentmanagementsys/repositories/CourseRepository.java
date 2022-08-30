package africa.semicolon.studentmanagementsys.repositories;

import africa.semicolon.studentmanagementsys.models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Long> {
}
