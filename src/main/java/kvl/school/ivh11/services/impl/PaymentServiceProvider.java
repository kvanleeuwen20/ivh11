package kvl.school.ivh11.services.impl;

import kvl.school.ivh11.Exception.PaymentException;
import kvl.school.ivh11.services.abstr.PaymentStrategy;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
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
        URL obj = new URL(url);
        HttpURLConnection httpCon = (HttpURLConnection) obj.openConnection();
        httpCon.setRequestMethod("POST");
        httpCon.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpCon.setRequestProperty("Content-Type", "application/json");

        OutputStream os = httpCon.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write("Just Some Text");
        osw.flush();
        osw.close();
        os.close();  //don't forget to close the OutputStream
        httpCon.connect();

        int responseCode = httpCon.getResponseCode();
        String result;
        BufferedInputStream bis = new BufferedInputStream(httpCon.getInputStream());
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result2 = bis.read();
        while(result2 != -1)
        {
            buf.write((byte) result2);
            result2 = bis.read();
        }
        result = buf.toString();

        return result;
    }
}
