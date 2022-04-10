package student.entity;

import student.exception.BadRequestException;

import javax.persistence.*;

@Entity
public class Score {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer score;

    public Score() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        if(score> 0 && score <= 100)
            this.score = score;
        else throw new BadRequestException("score must be between 1 and 100");
    }
}
