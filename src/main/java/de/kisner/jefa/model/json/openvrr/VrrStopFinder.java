package de.kisner.jefa.model.json.openvrr;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import de.kisner.jefa.model.json.openvrr.point.VrrPoint;

@JsonRootName(value="stopFinder")
@JsonIgnoreProperties(ignoreUnknown=true)
public class VrrStopFinder implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("message")
	private List<VrrParameter> parameters;
	public List<VrrParameter> getParameters() {return parameters;}
	public void setParameters(List<VrrParameter> parameters) {this.parameters = parameters;}

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