package de.kisner.jefa.model.json;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonTour implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("Line")
	private String line;
	public String getLine() {return line;}
	public void setLine(String line) {this.line = line;}
	
	@JsonProperty("Destination")
	private String destination;
	public String getDestination() {return destination;}
	public void setDestination(String destination) {this.destination = destination;}

	@JsonProperty("Time")
	private Date time;
	public Date getTime() {return time;}
	public void setTime(Date time) {this.time = time;}


	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}