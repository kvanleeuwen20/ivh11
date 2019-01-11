package kvl.school.ivh11.service.abstr;

import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.HashMap;

public interface PaymentStrategy
{
    void setConfigParams(HashMap<String, String> configValues);
    String buildRequestUri(String url) throws IOException;
    RedirectView preparePayment() throws IOException;
}