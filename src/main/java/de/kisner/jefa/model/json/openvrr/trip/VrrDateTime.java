package de.kisner.jefa.model.json.openvrr.trip;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="dateTime")
@JsonIgnoreProperties(ignoreUnknown=true)
public class VrrDateTime implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("time")
	private String time;
	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}

	@JsonProperty("rtTime")
	private String rtTime;
	public String getrtTime() {return rtTime;}
	public void setrtTime(String rtTime) {this.rtTime = rtTime;}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}