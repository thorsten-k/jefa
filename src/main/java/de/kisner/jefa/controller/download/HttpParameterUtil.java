package de.kisner.jefa.controller.download;

import org.apache.http.Header;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpParameterUtil 
{
	final static Logger logger = LoggerFactory.getLogger(HttpParameterUtil.class);
	
	public static CloseableHttpClient build()
	{
		HttpClientBuilder builder = HttpClients.custom();
		builder.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:45.0) Gecko/20100101 Firefox/45.0");
		return builder.build();
	}
	
	public static Header[] headers()
	{
		Header[] headers = {
			    new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
			    ,new BasicHeader("Accept-Language", "de,en-US;q=0.7,en;q=0.3")
			    ,new BasicHeader("Accept-Encoding", "gzip, deflate")
			    ,new BasicHeader("Connection", "keep-alive")
			    ,new BasicHeader("Referer", "http://efa.vrr.de/vrr/XSLT_DM_REQUEST")
			};
		return headers;
	}
}