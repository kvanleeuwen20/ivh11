package kvl.school.ivh11.services.impl;

import org.springframework.web.servlet.view.RedirectView;
import java.io.IOException;

public class MolliePSP extends PaymentServiceProvider
{
    @Override
    public RedirectView preparePayment() throws IOException
    {
        String url = cnf.get("mollieApiEndUrl");

        String response = buildRequestUri(url);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(response);
        return redirectView;
    }

    public void processFeedback(String trixid)
    {

    }

    public boolean isPaymentSuccessfull()
    {
        return false;
    }
}