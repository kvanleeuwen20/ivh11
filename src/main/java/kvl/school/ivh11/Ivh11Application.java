package kvl.school.ivh11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"kvl.school.ivh11.controller", "kvl.school.ivh11.service", "kvl.school.ivh11.security"})
@EntityScan("kvl.school.ivh11.domain")
@EnableJpaRepositories("kvl.school.ivh11.repository")
public class Ivh11Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Ivh11Application.class, args);
    }
}
