package de.kisner.github.jbefa.proxy;

import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

public class RequestContentType extends HttpFiltersSourceAdapter
{
	final static Logger logger = LoggerFactory.getLogger(RequestContentType.class);
		
	public static boolean relevant(HttpRequest request)
    {
		int index = request.getUri().lastIndexOf(".");
		
		if(index<0){return true;}
		if(!request.getUri().contains("http://efa")){return false;}
		
        String suffix = request.getUri().substring(index+1);
        
        boolean isGif = suffix.equals("gif");
        boolean isCss = suffix.equals("css");
        boolean isJs = suffix.equals("js");
        boolean isJpg = suffix.equals("jpg");
        boolean isPng = suffix.equals("png");
        boolean isIco = suffix.equals("ico");
        
        boolean relevant = !isGif && !isCss && !isJs && !isJpg && !isPng && !isIco;
        
        if(relevant)
        {
        	logger.trace(suffix);
        }
        
        return relevant;
    }
	
	public static boolean relevant(HttpResponse response)
    {
		logger.info(response.toString());
		
		String contentType = response.headers().get("Content-Type");
		
		return contentType.equals("text/html");
    }
}