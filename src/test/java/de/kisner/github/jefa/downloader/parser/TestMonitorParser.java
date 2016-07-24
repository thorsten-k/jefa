package de.kisner.github.jefa.downloader.parser;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.github.jefa.Bootstrap;
import de.kisner.github.jefa.downloader.parser.MonitorParser;
import de.kisner.github.jefa.model.json.JsonSchedule;
import de.kisner.github.jefa.model.json.JsonTour;

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