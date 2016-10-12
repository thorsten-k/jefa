package de.kisner.jefa.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonSchedule implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("Tours")
	private List<JsonTour> tours;
	public List<JsonTour> getTours() {if(tours==null){tours = new ArrayList<>();}return tours;}
	public void setTours(List<JsonTour> tours) {this.tours = tours;}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		return sb.toString();
	}
}