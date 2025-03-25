package example.day12._스프링스레드;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // [1] AppStart
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run( AppStart.class );
    }
} // class end