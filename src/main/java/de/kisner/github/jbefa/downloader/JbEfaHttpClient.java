package de.kisner.github.jbefa.downloader;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.exlp.util.io.StringUtil;

public class JbEfaHttpClient 
{
	final static Logger logger = LoggerFactory.getLogger(JbEfaHttpClient.class);
	
	public JbEfaHttpClient()
	{		

	}
	
	public void step1()
	{
		CloseableHttpClient httpclient = HttpParameterUtil.build();
        try
        {
            HttpHost target = new HttpHost("efa.vrr.de", 80, "http");
            HttpHost proxy = new HttpHost("127.0.0.1", 8080, "http");

            RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
            HttpGet request = new HttpGet("/vrr/XSLT_DM_REQUEST");
            request.setConfig(config);
            request.setHeaders(HttpParameterUtil.headers());
            
            logger.debug("Executing request " + request.getRequestLine() + " to " + target + " via " + proxy);

            CloseableHttpResponse response = httpclient.execute(target, request);
            try
            {
                logger.debug(StringUtil.stars());
                Header h = response.getFirstHeader("Set-Cookie");
                logger.info(h.toString());
                System.out.println(EntityUtils.toString(response.getEntity()));
            }
            finally {response.close();}
        }
        catch (IOException  e) {e.printStackTrace();}
        finally
        {
            try {httpclient.close();} catch (IOException e) {e.printStackTrace();}
        }
	}
}