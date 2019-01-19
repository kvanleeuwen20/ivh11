package kvl.school.ivh11.Components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Locale;

@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init(Locale locale)
    {
        accessor = new MessageSourceAccessor(messageSource, locale.ENGLISH);
    }

    public String get(String code, Object[] fields, Locale locale) {
        return accessor.getMessage(code, fields, locale);
    }

}