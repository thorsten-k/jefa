package de.kisner.github.jefa.proxy;

import java.util.List;

import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import net.sf.exlp.util.io.StringUtil;

public class VrrFilter extends HttpFiltersSourceAdapter
{
	final static Logger logger = LoggerFactory.getLogger(VrrFilter.class);
	
	private boolean debugRequest = true;
	
	public VrrFilter()
	{		
		
	}
	
	@Override public int getMaximumRequestBufferSizeInBytes() {return 10 * 1024 * 1024;}
	@Override public int getMaximumResponseBufferSizeInBytes() {return 10 * 1024 * 1024;}
	
	public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx)
    {
        return new HttpFiltersAdapter(originalRequest)
        {
            @Override
            public HttpResponse clientToProxyRequest(HttpObject ho)
            {            	
            	if(debugRequest && ho instanceof FullHttpRequest)
            	{
            		FullHttpRequest request = (FullHttpRequest)ho;
            		
            		if(RequestContentType.relevant(request))
            		{
            			logger.info(StringUtil.stars());
            			logger.info(request.getUri());
            			logger.info(request.toString());
            			
            			if(request.getMethod().equals(HttpMethod.POST))
            			{
            				HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(request);
                			decoder.setDiscardThreshold(0);

                			List<InterfaceHttpData> datas = decoder.getBodyHttpDatas();
                      		for(InterfaceHttpData data : datas)
                      		{
                      			logger.info("\t"+data.toString());
                      		}
            			}
            			
            		}
            	}
//            	System.exit(-1);
               return null;
            }

            @Override
            public HttpObject serverToProxyResponse(HttpObject ho)
            {
    			if(ho instanceof FullHttpResponse)
    			{
    				FullHttpResponse response = (FullHttpResponse)ho;
    				if(RequestContentType.relevant(response))
            		{
//            			logger.info(StringUtil.stars());
//            			logger.info(response.toString());
            			
            			ByteBuf buf = response.content();
            			byte[] bytes = new byte[buf.readableBytes()];
            			int readerIndex = buf.readerIndex();
            			buf.getBytes(readerIndex, bytes);
    					
//    					logger.info(new String(bytes));
            		}
    			}
                return ho;
            }
        };
    }
}