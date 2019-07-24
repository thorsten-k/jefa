package de.kisner.jefa.model.json.openvrr;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VrrParameter implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("name")
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@JsonProperty("value")
	private String value;
	public String getValue() {return value;}
	public void setValue(String value) {this.value = value;}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}