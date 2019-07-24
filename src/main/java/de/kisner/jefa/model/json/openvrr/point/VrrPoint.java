package de.kisner.jefa.model.json.openvrr.point;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import de.kisner.jefa.model.json.openvrr.trip.VrrDateTime;

@JsonRootName(value="point")
@JsonIgnoreProperties(ignoreUnknown=true)
public class VrrPoint implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("usage")
	private String usage;
	public String getUsage() {return usage;}
	public void setUsage(String usage) {this.usage = usage;}

	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	@JsonProperty("stateless")
	private String stateless;
	public String getStateless() {return stateless;}
	public void setStateless(String stateless) {this.stateless = stateless;}
	
	@JsonProperty("dateTime")
	private VrrDateTime dateTime;
	public VrrDateTime getDateTime() {return dateTime;}
	public void setDateTime(VrrDateTime dateTime) {this.dateTime = dateTime;}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}