package student.studentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import student.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("" +
            "SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Student s " +
            "WHERE s.firstname = ?1 and s.lastname =?2"
    )

    Boolean selectExistsNames(String firstname, String lastname);

    @Query("" +
            "SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Student s " +
            "WHERE s.email= ?1"
    )

    Boolean selectExistsEmail(String email);

    List<Student> findByFirstname(String firstName);
    List<Student> findByLastname(String lastName);
    List<Student> findStudentByEmail(String email);
}
