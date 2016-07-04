package de.kisner.github.jbefa.downloader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.exlp.util.io.StringIO;
import net.sf.exlp.util.io.StringUtil;

public class JbEfaHttpClient 
{
	final static Logger logger = LoggerFactory.getLogger(JbEfaHttpClient.class);
	
	private Configuration config;
	
	public JbEfaHttpClient(Configuration config)
	{		
		this.config=config;
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
	
	public void step2()
	{
		CloseableHttpClient httpclient = HttpParameterUtil.build();
        try
        {
            HttpHost target = new HttpHost("efa.vrr.de", 80, "http");
            HttpHost proxy = new HttpHost("127.0.0.1", 8080, "http");

            RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
            
            HttpPost post = new HttpPost("/vrr/XSLT_DM_REQUEST");
            post.setConfig(config);
            post.setHeaders(HttpParameterUtil.headers());
            
        	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        	urlParameters.add(new BasicNameValuePair("sessionID", "0"));
        	urlParameters.add(new BasicNameValuePair("language", "de"));
        	urlParameters.add(new BasicNameValuePair("requestID", "0"));
        	urlParameters.add(new BasicNameValuePair("command", ""));
        	urlParameters.add(new BasicNameValuePair("useRealtime", "1"));
        	urlParameters.add(new BasicNameValuePair("itdLPxx_view", ""));
        	urlParameters.add(new BasicNameValuePair("ptOptionsActive", "1"));
        	urlParameters.add(new BasicNameValuePair("useProxFootSearch", "0"));
        	
        	urlParameters.add(new BasicNameValuePair("deleteAssignedStops_dm", "1"));
        	urlParameters.add(new BasicNameValuePair("itdLPxx_mdvMap2_dm", ""));
        	urlParameters.add(new BasicNameValuePair("itdLPxx_mapState_dm", ""));
        	urlParameters.add(new BasicNameValuePair("itdLPxx_mdvMap_dm", "3406199:401077:NAV3"));
        	urlParameters.add(new BasicNameValuePair("itdLPxx_transpCompany", "vrr"));
        	urlParameters.add(new BasicNameValuePair("placeInfo_dm", "invalid"));
        	urlParameters.add(new BasicNameValuePair("typeInfo_dm", "invalid"));
        	urlParameters.add(new BasicNameValuePair("nameInfo_dm", "invalid"));
        	urlParameters.add(new BasicNameValuePair("placeState_dm", "empty"));
        	urlParameters.add(new BasicNameValuePair("nameState_dm", "empty"));
        	urlParameters.add(new BasicNameValuePair("useHouseNumberList_dm", "1"));
        	
        	urlParameters.add(new BasicNameValuePair("place_dm", "Oer-Erkenschwick"));
        	urlParameters.add(new BasicNameValuePair("type_dm", "stop"));
        	urlParameters.add(new BasicNameValuePair("name_dm", "Birkenweg"));
        	urlParameters.add(new BasicNameValuePair("itdLPxx_id_dm", ":dm"));
        	
        	urlParameters.add(new BasicNameValuePair("itdTimeHour", "06"));
        	urlParameters.add(new BasicNameValuePair("itdTimeMinute", "27"));
        	urlParameters.add(new BasicNameValuePair("itdDateDay", "02"));
        	urlParameters.add(new BasicNameValuePair("itdDateMonth", "07"));
        	urlParameters.add(new BasicNameValuePair("itdDateYear", "2016"));
        	urlParameters.add(new BasicNameValuePair("submitButton", "anfordern"));
        	
        	
        	post.setEntity(new UrlEncodedFormEntity(urlParameters));

            
            logger.debug("Executing request " + post.getRequestLine() + " to " + target + " via " + proxy);

            CloseableHttpResponse response = httpclient.execute(target, post);
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
	
	public void step3()
	{
		CloseableHttpClient httpclient = HttpParameterUtil.build();
        try
        {
            HttpHost target = new HttpHost("efa.vrr.de", 80, "http");
            HttpHost proxy = new HttpHost("127.0.0.1", 8080, "http");
            
            HttpPost post = new HttpPost("/vrr/XSLT_DM_REQUEST");
            post.setConfig(RequestConfig.custom().setProxy(proxy).build());
            post.setHeaders(HttpParameterUtil.headers());
            
        	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        	urlParameters.add(new BasicNameValuePair("sessionID", "efa3.vrr.de_95741900"));
        	urlParameters.add(new BasicNameValuePair("language", "de"));
        	urlParameters.add(new BasicNameValuePair("requestID", "1"));
        	urlParameters.add(new BasicNameValuePair("command", ""));
        	urlParameters.add(new BasicNameValuePair("useRealtime", "1"));
        	urlParameters.add(new BasicNameValuePair("itdLPxx_view", ""));
        	urlParameters.add(new BasicNameValuePair("ptOptionsActive", "1"));
        	urlParameters.add(new BasicNameValuePair("useProxFootSearch", "0"));
        	urlParameters.add(new BasicNameValuePair("deleteAssignedStops_dm", "1"));
        	
        	urlParameters.add(new BasicNameValuePair("itdLPxx_mdvMap2_dm", "3406199:401077:NAV3"));
        	urlParameters.add(new BasicNameValuePair("itdLPxx_mapState_dm", ""));
        	urlParameters.add(new BasicNameValuePair("itdLPxx_mdvMap_dm", "3406199:401077:NAV3"));
        	urlParameters.add(new BasicNameValuePair("itdLPxx_transpCompany", "vrr"));
        	urlParameters.add(new BasicNameValuePair("dmLineSelection", "5:1"));
        	
        	urlParameters.add(new BasicNameValuePair("submitButton", "anfordern"));
        	
        	
        	post.setEntity(new UrlEncodedFormEntity(urlParameters));

            
            logger.debug("Executing request " + post.getRequestLine() + " to " + target + " via " + proxy);

            CloseableHttpResponse response = httpclient.execute(target, post);
            try
            {
                logger.debug(StringUtil.stars());
                Header h = response.getFirstHeader("Set-Cookie");
                logger.info(h.toString());
                String s = EntityUtils.toString(response.getEntity());
                
                String file = config.getString("file.response.stage3");
                logger.info("Saving to "+file);
                StringIO.writeTxt(new File(file), s);
                
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