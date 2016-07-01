package de.kisner.github.jbefa.downloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.github.jbefa.Bootstrap;
import de.kisner.github.jbefa.proxy.HttpProxy;

public class TestJbEfaDownloader 
{
	final static Logger logger = LoggerFactory.getLogger(TestJbEfaDownloader.class);
	
	public static void main(String args[]) throws Exception
	{		
		Bootstrap.init();
		HttpProxy.start();
		
		JbEfaHttpClient cli = new JbEfaHttpClient();
		cli.step1();
	}
}