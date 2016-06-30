package de.kisner.github.jbmessage.proxy.util;

import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestContentType extends HttpFiltersSourceAdapter
{
	final static Logger logger = LoggerFactory.getLogger(RequestContentType.class);
		
	public static boolean relevant(String uri)
    {
		int index = uri.lastIndexOf(".");
		
		if(index<0){return true;}
		if(!uri.contains("http://efa")){return false;}
		
        String suffix = uri.substring(index+1);
        
        boolean isGif = suffix.equals("gif");
        boolean isCss = suffix.equals("css");
        boolean isJs = suffix.equals("js");
        boolean isJpg = suffix.equals("jpg");
        
        boolean relevant = !isGif && !isCss && !isJs && !isJpg;
        
        if(relevant)
        {
        	logger.trace(suffix);
        }
        
        return relevant;
    }
}