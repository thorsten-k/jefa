package de.kisner.jefa.interfaces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface OpenVrrJsonRest
{		
	@GET @Path("/XML_STOPFINDER_REQUEST") @Produces(MediaType.TEXT_PLAIN)
	String stopFinder(@QueryParam("outputFormat") String outputFormat,
					@QueryParam("stateless") String stateless,
					@QueryParam("locationServerActive") String locationServerActive,
					@QueryParam("coordOutputFormat") String coordOutputFormat,
					
					@QueryParam("coordOutputFormatTail") String coordOutputFormatTail,
					@QueryParam("type_sf") String typeSf,
					@QueryParam("anyMaxSizeHitList") String anyMaxSizeHitList,
					@QueryParam("anyObjFilter_sf") String anyObjFilterSf,
					@QueryParam("w_regPrefAl") String wRegPrefAl,
					@QueryParam("name_sf") String nameSf
			);
	
	@GET @Path("/XML_TRIP_REQUEST2") @Produces(MediaType.TEXT_PLAIN)
	String tripFinder(@QueryParam("outputFormat") String outputFormat,
					@QueryParam("stateless") String stateless,
					@QueryParam("locationServerActive") String locationServerActive,
					@QueryParam("coordOutputFormat") String coordOutputFormat,
					
					@QueryParam("useRealtime") int useRealtime,
					@QueryParam("name_origin") String nameOrigin,
					@QueryParam("name_destination") String nameDestination,
					@QueryParam("type_origin") String typeOrigin,
					@QueryParam("type_destination") String typeDestination
			);
	
	
}