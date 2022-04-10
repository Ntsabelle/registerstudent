package student.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE)

    private Long studentid;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDate dob;

    private String cellphone_number;

    private Double avr;

    @OneToMany(targetEntity = Score.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ss_fk",referencedColumnName = "studentid")
    private List<Score> scores;

    public Student() {
        scores = new ArrayList<>();
    }


    public Student(String firstname, String lastname, String email, LocalDate dob, String cellphone_number, List<Score> scores) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.cellphone_number = cellphone_number;
        this.scores = scores;
    }

    public Student(Long studentid, String firstname, String lastname, String email, LocalDate dob, String cellphone_number, List<Score> scores) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.cellphone_number = cellphone_number;
        this.scores = scores;
    }

    public Student(String firstname, String lastname, String email, LocalDate dob, String cellphone_number) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.cellphone_number = cellphone_number;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCellphone_number() {
        return cellphone_number;
    }

    public void setCellphone_number(String cellphone_number) {
        this.cellphone_number = cellphone_number;
    }

    public Double getAvr() {
        return avr= calcAvr();
    }

    public void setAvr(Double avr) {


        this.avr = calcAvr();
    }

    //Average cal function
    public Double calcAvr()
    {

        float sum =0;
        Double aver =0.0;
        for (Score score:scores)
        {
            sum+=score.getScore();
            aver= Double.valueOf((sum/scores.size()));
        }
        return aver;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", cellphone_number='" + cellphone_number + '\'' +
                ", avr=" + avr +
                ", scores=" + scores +
                '}';
    }
}
