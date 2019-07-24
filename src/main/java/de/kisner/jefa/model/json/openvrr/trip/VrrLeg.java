package de.kisner.jefa.model.json.openvrr.trip;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import de.kisner.jefa.model.json.openvrr.point.VrrPoint;

@JsonRootName(value="leg")
@JsonIgnoreProperties(ignoreUnknown=true)
public class VrrLeg implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("timeMinute")
	private String timeMinute;
	public String getTimeMinute() {return timeMinute;}
	public void setTimeMinute(String timeMinute) {this.timeMinute = timeMinute;}
	
	@JsonProperty("mode")
	private VrrMode mode;
	public VrrMode getMode() {return mode;}
	public void setMode(VrrMode mode) {this.mode = mode;}
	
	@JsonProperty("points")
	private List<VrrPoint> points;
	public List<VrrPoint> getPoints() {return points;}
	public void setPoints(List<VrrPoint> points) {this.points = points;}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}