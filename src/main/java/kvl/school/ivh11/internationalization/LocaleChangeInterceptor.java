package kvl.school.ivh11.internationalization;

import org.springframework.context.annotation.Bean;

public class LocaleChangeInterceptor
{
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor()
    {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        return localeChangeInterceptor;
    }
}
