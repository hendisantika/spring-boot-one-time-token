package id.my.hendisantika.onetimetoken;

import id.my.hendisantika.onetimetoken.model.User;
import id.my.hendisantika.onetimetoken.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@EnableScheduling
@SpringBootApplication
public class SpringBootOneTimeTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOneTimeTokenApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return (args) -> {
            userRepository.saveAll(
                    List.of(new User("Itadori", "Yuji", "yuji", "53cret", "yuji@yopmail.com", "+6281321411800"),
                            new User("Fushiguro", "Megumi", "megumi", "53cret", "megumi@yopmail.com", "+6281321411801"),
                            new User("Satoru", "Gojo", "gojo", "53cret", "gojo@yopmail.com", "+6281321411802")));
        };
    }
}
