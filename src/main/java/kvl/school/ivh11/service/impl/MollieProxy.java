package kvl.school.ivh11.service.impl;

import com.jayway.jsonpath.JsonPath;
import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.OrderState;
import kvl.school.ivh11.service.abstr.PSPProxy;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

public class MollieProxy implements PSPProxy
{
    private HashMap<String, String> config;
    private boolean isServiceAvailable = false;
    private void setConfigParams(HashMap<String, String> params)
    {
        this.config = params;
    }

    @Override
    public String process(Order o)
    {
        String response = "error";
        if(o.getState() == OrderState.PENDING)
            response = "wait";
        else{
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            final String url = config.get("mollieApiHost");
            Map<String, String> params = new HashMap<String, String>();
            params.put("apiKey", config.get("apiKey"));
            HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
            RestTemplate restTemplate = new RestTemplate();
            Object r = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

            if (((ResponseEntity) r).getStatusCode().is2xxSuccessful())
            {
                String output = (String)((ResponseEntity) r).getBody();
                String read = JsonPath.read(output, "$._links.[self].href");

                response = read;
            }
        }
        return response;
    }

    private ModelAndView doContinueCheckout(String url)
    {
        return new ModelAndView("redirect:" + url);
    }

    private ModelAndView showWaitView(Order o)
    {
        return
    }

}
