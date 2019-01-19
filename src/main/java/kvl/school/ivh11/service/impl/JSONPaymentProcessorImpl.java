package kvl.school.ivh11.service.impl;

import com.jayway.jsonpath.JsonPath;
import kvl.school.ivh11.Components.Messages;
import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.OrderState;
import kvl.school.ivh11.service.PaymentResult;
import kvl.school.ivh11.service.abstr.CommunicationHandler;
import kvl.school.ivh11.service.abstr.JsonPaymentProcessorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class JSONPaymentProcessorImpl extends JsonPaymentProcessorStrategy
{
    private HashMap<String, String> cnf;
    private String name;

    @Autowired
    Messages message;

    @Override
    protected void setParams(HashMap<String, String> cnf)
    {
        this.cnf = cnf;
    }

    @Override
    protected String getCheckOutUrl(Order o)
    {
        String response = "";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        final String url = cnf.get("apiHost");
        Map<String, String> params = new HashMap<String, String>();
        params.put("apiKey", cnf.get("apiKey"));
        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Object r = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        if (((ResponseEntity) r).getStatusCode().is2xxSuccessful())
        {
            String output = (String)((ResponseEntity) r).getBody();
            String read = JsonPath.read(output, "$._links.[self].href");

            response = read;
        }
        return response;
    }

    @Override
    protected void completeRequest(PaymentResult result)
    {
        if(result.getState().getState() == "PAID")
        {
            result.getPayment().getOrder().setState(OrderState.PAID);
            //in this example we sent a sms

            String messageData[] = { result.getPayment().getOrder().getCustomer().getName(), String.valueOf(result.getPayment().getOrder().getId()) };
            String msg = message.get("smsMesage.sendOrderNotificationWherePaid", messageData, Locale.ENGLISH);

            SmsData data = new SmsData();
            data.setMessage(msg);
            data.setReceiver(result.getPayment().getOrder().getCustomer().getMobNr());
            CommunicationHandler cm = new SmsHandler(data);
            cm.send();
        }
    }

    private void redirect(Order o)
    {

    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }
}
