package de.kisner.jefa.model.json.openvrr.point;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="origin")
@JsonIgnoreProperties(ignoreUnknown=true)
public class VrrOrigin implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("points")
	private VrrPoints points;
	public VrrPoints getPoints() {return points;}
	public void setPoints(VrrPoints points) {this.points = points;}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}