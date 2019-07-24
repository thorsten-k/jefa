package de.kisner.jefa.controller.web;

import java.io.IOException;

import org.apache.commons.configuration.Configuration;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jeesl.util.web.RestLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;

import de.kisner.jefa.Bootstrap;
import de.kisner.jefa.controller.proxy.JsonRestProxy;
import de.kisner.jefa.interfaces.OpenVrrJsonRest;
import de.kisner.jefa.model.json.openvrr.VrrResponse;
import net.sf.exlp.util.io.JsonUtil;

public class CliJsonRest 
{
	final static Logger logger = LoggerFactory.getLogger(CliJsonRest.class);
	
	private JsonRestProxy rest;
	
	public CliJsonRest() throws JsonParseException, IOException
	{
		ResteasyClient client = new ResteasyClientBuilder().build();
	//	client.register(new BasicAuthentication(restUser, restPwd));
		ResteasyWebTarget restTarget = client.target("http://openservice-test.vrr.de/static02");
		
		client.register(new RestLogger());
		rest = new JsonRestProxy(restTarget.proxy(OpenVrrJsonRest.class));
				
//		VrrResponse r1 = JsonRestProxy.stopFinder(rest,"Essen Hbf");
//		JsonUtil.info(r1);
//		
//		VrrResponse r2 = JsonRestProxy.stopFinder(rest,"Recklinghausen Hbf");
//		JsonUtil.info(r2);
		
		VrrResponse r3 = rest.tripFinder("20003581","20009289");
		JsonUtil.info(r3);
	}
	
	public static void main(String args[]) throws Exception
	{		
		Configuration config = Bootstrap.init();
		CliJsonRest cli = new CliJsonRest();
		
	}
}