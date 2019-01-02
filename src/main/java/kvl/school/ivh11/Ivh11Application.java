package kvl.school.ivh11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("kvl.school.ivh11.repositories")
public class Ivh11Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Ivh11Application.class, args);
    }
}
