package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.service.PaymentResult;
import kvl.school.ivh11.service.abstr.XmlPamentProcessorStrategy;

import java.util.HashMap;

public class XmlPamentProcessorStrategyImpl extends XmlPamentProcessorStrategy
{
    @Override
    protected void completeRequest(HashMap<String, String> cnf, PaymentResult result)
    {

    }

    @Override
    protected String getCheckOutUrl(Order o) {
        return null;
    }
}
