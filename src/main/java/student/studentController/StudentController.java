package student.studentController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.studentService.StudentService;
import student.entity.Student;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {

        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentid){
        return new ResponseEntity<Student>(studentService.getStudentById(studentid), HttpStatus.OK);
    }
    @GetMapping("firstname")
    public ResponseEntity<List<Student>> getStudentByFirstName(@RequestParam String firstname){
        return new ResponseEntity<List<Student>>(studentService.getStudentByFirstName(firstname),HttpStatus.OK);

    }
    @GetMapping("lastname")
    public ResponseEntity<List<Student>> getStudentByLastName(@RequestParam String lastname){
        return new ResponseEntity<List<Student>>(studentService.getStudentByLastName(lastname),HttpStatus.OK);

    }

    @GetMapping("email")
    public ResponseEntity<List<Student>> getStudentByEmail(@RequestParam String email){
        return new ResponseEntity<List<Student>>(studentService.getStudentByEmail(email),HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long studentid
            ,@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student, studentid), HttpStatus.OK);
    }

    @DeleteMapping(path = "{studentid}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable("studentid") Long studentId) {
        studentService.deleteStudent(studentId);

        return new ResponseEntity<String>("Student deleted successfully!.", HttpStatus.OK);


    }
}


