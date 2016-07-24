package de.kisner.github.jbefa.proxy;

import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.github.jefa.Bootstrap;

public class HttpProxy 
{
	final static Logger logger = LoggerFactory.getLogger(HttpProxy.class);
	
	public static void start()
	{
		DefaultHttpProxyServer.bootstrap()
        .withPort(8080)
        .withFiltersSource(new VrrFilter())
        .start();
	}
	
	public static void main(String args[]) throws Exception
	{		
		Bootstrap.init();
		HttpProxy.start();
	}
}