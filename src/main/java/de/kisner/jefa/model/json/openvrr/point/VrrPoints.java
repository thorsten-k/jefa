package de.kisner.jefa.model.json.openvrr.point;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="points")
@JsonIgnoreProperties(ignoreUnknown=true)
public class VrrPoints implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("point")
	private List<VrrPoint> points;
	public List<VrrPoint> getPoints() {return points;}
	public void setPoints(List<VrrPoint> points) {this.points = points;}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}