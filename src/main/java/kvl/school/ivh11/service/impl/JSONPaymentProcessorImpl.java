package kvl.school.ivh11.service.impl;

import com.jayway.jsonpath.JsonPath;
import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.service.PaymentResult;
import kvl.school.ivh11.service.abstr.JsonPaymentProcessorStrategy;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class JSONPaymentProcessorImpl extends JsonPaymentProcessorStrategy
{
    private HashMap<String, String> cnf;

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
    protected void completeRequest(PaymentResult result) {

    }
}
