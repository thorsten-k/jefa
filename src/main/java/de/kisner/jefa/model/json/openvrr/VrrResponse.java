package de.kisner.jefa.model.json.openvrr;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import de.kisner.jefa.model.json.openvrr.point.VrrOrigin;
import de.kisner.jefa.model.json.openvrr.trip.VrrTrip;

@JsonRootName(value="response")
@JsonIgnoreProperties(ignoreUnknown=true)
public class VrrResponse implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("parameters")
	private List<VrrParameter> parameters;
	public List<VrrParameter> getParameters() {return parameters;}
	public void setParameters(List<VrrParameter> parameters) {this.parameters = parameters;}

	@JsonProperty("stopFinder")
	private VrrStopFinder stopFinder;
	public VrrStopFinder getStopFinder() {return stopFinder;}
	public void setStopFinder(VrrStopFinder stopFinder) {this.stopFinder = stopFinder;}
	
	@JsonProperty("origin")
	private VrrOrigin origin;
	public VrrOrigin getOrigin() {return origin;}
	public void setOrigin(VrrOrigin origin) {this.origin = origin;}
	
	@JsonProperty("destination")
	private VrrOrigin destination;
	public VrrOrigin getDestination() {return destination;}
	public void setDestination(VrrOrigin destination) {this.destination = destination;}
	
	@JsonProperty("trips")
	private List<VrrTrip> trips;
	public List<VrrTrip> getTrips() {return trips;}
	public void setTrips(List<VrrTrip> trips) {this.trips = trips;}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}