package student.studentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.emailValidator.EmailValidator;
import student.entity.Student;
import student.exception.BadRequestException;
import student.exception.StudentNotFoundException;
import student.studentRepository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final EmailValidator emailValidator;


    @Autowired
    public StudentService(StudentRepository studentRepository, EmailValidator emailValidator) {
        this.studentRepository = studentRepository;
        this.emailValidator = emailValidator;
    }

    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepository.findByFirstname(firstName);
    }

    public List<Student> getStudentByLastName(String lastname) {
        return studentRepository.findByLastname(lastname);
    }

    public List<Student> getStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }

    public Student getStudentById(long studentid) {

        return studentRepository.findById(studentid).orElseThrow(() ->
                new StudentNotFoundException(
                        "Student with id " + studentid + " does not exists"));

    }

    public Student saveStudent(Student student) {

        Boolean mailTaken = studentRepository.selectExistsEmail(student.getEmail());
        Boolean namesTaken = studentRepository.selectExistsNames(student.getFirstname(),student.getLastname());

        if (!emailValidator.test(student.getEmail())) {
            throw new BadRequestException(student.getEmail() + " is not valid");
        }

        if (namesTaken) {
            throw new BadRequestException(" Student with first Name: "
                    + student.getFirstname() +" and Last Name: "+student.getLastname() +" already exist in our DB");
        }
        else

        if (mailTaken) {
            throw new BadRequestException(" Student with: "
                    + student.getEmail() + " already exist in our DB");
        }

        return studentRepository.save(student);
    }

    public Student updateStudent(Student student, long studentid) {

        // we need to check whether student with given id exists in DB or not
        Student existingStudent= studentRepository.findById(studentid).orElseThrow(
                () -> new StudentNotFoundException(
                        "Student with id " + studentid + " does not exists"));

        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastname(student.getLastname());
        existingStudent.setEmail(student.getLastname());
        existingStudent.setCellphone_number(student.getCellphone_number());
        existingStudent.setDob(student.getDob());
        // save existing Student to DB
        studentRepository.save(existingStudent);
        return existingStudent;
    }


    public void deleteStudent(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new StudentNotFoundException("Student with id " + studentId + " does not exists");
        }

        studentRepository.deleteById(studentId);

    }
}
