package sis.nucleo.it.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@ComponentScan({"sis.nucleo.it"})
@SpringBootApplication(scanBasePackages={"sis.nucleo.it"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
