package de.kisner.jefa.factory.json;

import java.util.Date;

import org.joda.time.DateTime;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.jefa.model.json.JsonTour;
import net.sf.exlp.util.DateUtil;
import net.sf.exlp.util.io.StringUtil;

public class JsonTourFactory
{
	final static Logger logger = LoggerFactory.getLogger(JsonTourFactory.class);
	
	public static JsonTour build(Element tr)
	{
		JsonTour json = new JsonTour();
	
		Elements tds = tr.select("tr > td");
	
		logger.info(StringUtil.stars());
		logger.info(tr.outerHtml());
		String[] time = tds.get(1).ownText().trim().split(":");
		
		DateTime dt = new DateTime(new Date());
		json.setTime(DateUtil.getDateFromInt(dt.getYear(), dt.getMonthOfYear(),dt.getDayOfMonth(), new Integer(time[0]), new Integer(time[1]), 0));
		json.setLine(tds.get(4).ownText().trim());
		json.setDestination(tds.get(6).ownText().trim());
		
		
		return json;
	}
}