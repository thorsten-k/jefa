package de.kisner.jefa.model.json.openvrr.trip;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="mode")
@JsonIgnoreProperties(ignoreUnknown=true)
public class VrrMode implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("number")
	private String number;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}