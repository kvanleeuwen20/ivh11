package kvl.school.ivh11.security;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
import java.util.Arrays;
import java.util.List;


//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration
{

  public static List<String> whiteListedIps = Arrays.asList("80.255.244.6");
   //
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.cors()
//                .and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/authentication/login").permitAll()
//                .antMatchers("/resources/**").permitAll()
//                .anyRequest().permitAll();
//
//        whiteListedIps.add("90.255.244.6");
//    }
}
//
