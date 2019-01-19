package kvl.school.ivh11;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.domain.Screen;
import kvl.school.ivh11.domain.Screening;
import kvl.school.ivh11.repository.FilmRepo;
import kvl.school.ivh11.repository.ScreenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = {"kvl.school.ivh11.controller", "kvl.school.ivh11.service", "kvl.school.ivh11.security", "kvl.school.ivh11.cnf"})
@EntityScan("kvl.school.ivh11.domain")
@EnableJpaRepositories("kvl.school.ivh11.repository")
public class Ivh11Application
{
    public static void main(String[] args) {
        SpringApplication.run(Ivh11Application.class, args);
    }
}
