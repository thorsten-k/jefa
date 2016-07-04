package de.kisner.github.jbefa.downloader.parser;

import java.io.File;

import org.apache.commons.configuration.Configuration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.github.jbefa.factory.json.JsonTourFactory;
import de.kisner.github.jbefa.model.json.JsonSchedule;
import net.sf.exlp.util.io.StringIO;

public class MonitorParser 
{
	final static Logger logger = LoggerFactory.getLogger(MonitorParser.class);
	
	private Configuration config;
	
	public MonitorParser(Configuration config)
	{		
		this.config=config;
	}
	

	
	public JsonSchedule parse()
	{	
		
		String file = config.getString("file.response.stage3");
		logger.info("Saving to "+file);
		String s = StringIO.loadTxt(new File(file));
		
		Document doc = Jsoup.parse(s);
		Element tables = doc.select("TD:containsOwn(Zeit)").first();
		Element t = tables.parent().parent();
		
		logger.trace(t.outerHtml());
 
		Elements trs = t.select("tbody > tr:gt(0):lt(2)");
 
		JsonSchedule schedule = new JsonSchedule();
		for(Element tr : trs)
		{
			schedule.getTours().add(JsonTourFactory.build(tr));
		}
		return schedule;
	}
}