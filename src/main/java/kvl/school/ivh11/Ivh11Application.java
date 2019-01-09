package kvl.school.ivh11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"kvl.school.ivh11.controllers", "kvl.school.ivh11.services", "kvl.school.ivh11.security"})
@EntityScan("kvl.school.ivh11.domain")
@EnableJpaRepositories("kvl.school.ivh11.repositories.abstr")
public class Ivh11Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Ivh11Application.class, args);
    }
}
