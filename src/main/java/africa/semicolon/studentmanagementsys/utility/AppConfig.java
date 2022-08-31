package africa.semicolon.studentmanagementsys.utility;

import africa.semicolon.studentmanagementsys.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    static StudentRepository studentRepository;
    @Bean
    public ModelMapper returnMapper(){
        return new ModelMapper();
    }




}
