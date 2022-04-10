package student.studentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.entity.Score;

public interface ScoreRepository extends JpaRepository<Score,Long> {

}
