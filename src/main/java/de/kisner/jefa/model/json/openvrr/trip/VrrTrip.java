package de.kisner.jefa.model.json.openvrr.trip;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="trip")
@JsonIgnoreProperties(ignoreUnknown=true)
public class VrrTrip implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("duration")
	private String duration;
	public String getDuration() {return duration;}
	public void setDuration(String duration) {this.duration = duration;}

	@JsonProperty("legs")
	private List<VrrLeg> legs;
	public List<VrrLeg> getLegs() {return legs;}
	public void setLegs(List<VrrLeg> legs) {this.legs = legs;}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}