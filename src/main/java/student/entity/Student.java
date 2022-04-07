package student.entity;

import student.exception.BadRequestException;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table
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

    private Integer current_score;

    public Student()
    {}


    public Student(Long studentid, String firstname, String lastname, LocalDate dob, String cellphone_number, String email_address, Integer current_score) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.cellphone_number = cellphone_number;
        this.email = email_address;
        this.current_score = current_score;
    }

    public Student(String firstname, String lastname, LocalDate dob, String cellphone_number, String email_address, Integer current_score) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.cellphone_number = cellphone_number;
        this.email = email_address;
        this.current_score = current_score;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email_address) {
        this.email = email_address;
    }

    public Integer getCurrent_score() {
        return current_score;
    }

    public void setCurrent_score(Integer current_score) {
        if(current_score> 0 && current_score <= 100)
        this.current_score = current_score;

        else throw new BadRequestException("score must be between 1 and 100");
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob=" + dob +
                ", cellphone_number='" + cellphone_number + '\'' +
                ", email_address='" + email + '\'' +
                ", current_score=" + current_score +
                '}';
    }
}
