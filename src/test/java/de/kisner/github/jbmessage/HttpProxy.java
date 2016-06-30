package de.kisner.github.jbmessage;

import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.github.Bootstrap;
import de.kisner.github.jbmessage.proxy.filter.VrrFilter;

public class HttpProxy 
{
	final static Logger logger = LoggerFactory.getLogger(HttpProxy.class);
	
	public static void main(String args[]) throws Exception
	{		
		Bootstrap.init();
		
		HttpProxyServer server =
			    DefaultHttpProxyServer.bootstrap()
			        .withPort(8080)
			        .withFiltersSource(new VrrFilter())
			        .start();
	}
}