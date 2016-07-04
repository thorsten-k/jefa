package de.kisner.github.jbefa.downloader.parser;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.github.jbefa.Bootstrap;
import de.kisner.github.jbefa.model.json.JsonSchedule;
import de.kisner.github.jbefa.model.json.JsonTour;

public class TestMonitorParser 
{
	final static Logger logger = LoggerFactory.getLogger(TestMonitorParser.class);
	
	public static void main(String args[]) throws Exception
	{		
		Configuration config = Bootstrap.init();
		
		MonitorParser cli = new MonitorParser(config);
		JsonSchedule schedule = cli.parse();
		for(JsonTour t : schedule.getTours())
		{
			logger.info("\t"+t.getLine()+" "+t.getDestination()+" "+t.getTime());
		}
	}
}