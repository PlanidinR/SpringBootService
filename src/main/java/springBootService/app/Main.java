package springBootService.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Planidin Roman
 * @version v1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = "springBootService")
public class Main {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws ClassNotFoundException {
        SpringApplication.run(Main.class);
    }
}
