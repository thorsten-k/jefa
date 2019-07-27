package de.kisner.jefa.controller.proxy;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.kisner.jefa.interfaces.OpenVrrJsonRest;
import de.kisner.jefa.model.json.openvrr.VrrResponse;
import net.sf.exlp.util.io.JsonUtil;

public class JsonRestProxy implements Serializable
{
	public static final long serialVersionUID=1;

	private final OpenVrrJsonRest rest;
	
	public JsonRestProxy(OpenVrrJsonRest rest)
	{
		this.rest=rest;
	}
	
	public VrrResponse stopFinder(String name) throws JsonParseException, JsonMappingException, IOException {return JsonRestProxy.stopFinder(rest, name);}
	public VrrResponse tripFinder(String origin, String destination) throws JsonParseException, JsonMappingException, IOException {return JsonRestProxy.tripFinder(rest,origin,destination);}
	
	public static VrrResponse stopFinder(OpenVrrJsonRest rest, String name) throws JsonParseException, JsonMappingException, IOException
	{
		String s = rest.stopFinder("JSON","1","1","WGS84[DD.DDDDD]","5","any","64","126","2",name);
		VrrResponse r = JsonUtil.read(VrrResponse.class, s.getBytes());
		return r;
	}
	
	public static VrrResponse tripFinder(OpenVrrJsonRest rest, String origin, String destination) throws JsonParseException, JsonMappingException, IOException
	{
		String s = rest.tripFinder("JSON","1","1","WGS84[DD.DDDDD]",1,
						origin,destination,
						"any","any");
		VrrResponse r = JsonUtil.read(VrrResponse.class, s.getBytes());
		return r;
	}
}