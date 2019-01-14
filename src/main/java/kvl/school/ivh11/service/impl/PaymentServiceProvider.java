package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.service.abstr.PaymentStrategy;

import java.io.*;
import java.util.HashMap;

public abstract class PaymentServiceProvider implements PaymentStrategy
{
    protected HashMap<String, String> cnf;

    @Override
    public final void setConfigParams(HashMap<String, String> configValues)
    {
        cnf = configValues;
    }

    public String buildRequestUri(String url) throws IOException {
        //ToDo
        return null;
    }
}
