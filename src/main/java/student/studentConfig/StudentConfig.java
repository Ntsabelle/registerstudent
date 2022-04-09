package student.studentConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import student.entity.Student;
import student.studentRepository.StudentRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return arg -> {

                    Student std1 =
                            new Student("Tsitso",
                                    "Ntsabi",
                                    LocalDate.of(2001, Month.FEBRUARY,06),
                                    "0735619861",
                                    "tsits@gmail.com",
                                    10);
            Student std2 =
                    new Student("Mpho",
                            "Waka",
                            LocalDate.of(2000, Month.OCTOBER,06),
                            "0835619861",
                            "Mpho@gmail.com",
                            14);


            repository.saveAll(
                    List.of(std1,std2));
        };
    }

}
