package de.kisner.github.jbmessage.proxy.filter;

import java.util.List;
import java.util.Set;

import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.github.jbmessage.proxy.util.RequestContentType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import net.sf.exlp.util.io.StringUtil;

public class VrrFilter extends HttpFiltersSourceAdapter
{
	final static Logger logger = LoggerFactory.getLogger(VrrFilter.class);
	
	public VrrFilter()
	{		
		
	}
	
	public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx)
    {
        return new HttpFiltersAdapter(originalRequest)
        {
            @Override
            public HttpResponse clientToProxyRequest(HttpObject ho)
            {
            	
            	if(ho instanceof DefaultHttpRequest)
            	{
            		DefaultHttpRequest hr = (DefaultHttpRequest)ho;
            		
            		logger.info("Full? "+(hr instanceof DefaultFullHttpRequest));
            		
            		if(RequestContentType.relevant(hr.getUri()))
            		{
            			logger.info(StringUtil.stars());
            			logger.info(hr.getUri());
                    	Set<String> set = hr.headers().names();
                		for(String s : set)
                		{
                //			logger.info(s+": "+hr.headers().get(s));
                		}
                		logger.info(hr.toString());
                		
                		
                		HttpPostRequestDecoder d = new HttpPostRequestDecoder(hr);
                		logger.info("Size:"+d.isMultipart());
                		d.offer((HttpContent)hr);
                		List<InterfaceHttpData> datas = d.getBodyHttpDatas();
                		logger.info("Size:"+datas.size());
                		
                		
                	
            		}
            		
            		
            	}
            	
               return null;
            }

            @Override
            public HttpObject serverToProxyResponse(HttpObject ho)
            {
            	
            	if(ho instanceof DefaultHttpResponse)
            	{
            		DefaultHttpResponse hr = (DefaultHttpResponse)ho;
            		Set<String> set = hr.headers().names();
            		for(String s : set)
            		{
           // 			logger.info(s+": "+hr.headers().get(s));
            		}
            	}
                return ho;
            }
        };
    }
}