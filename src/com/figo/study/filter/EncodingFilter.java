package com.figo.study.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * EncodingFilter.java
 * 
 * @author  liu.wei
 * @version $Revision: 1.0 $ $Date: $
 * @serial 
 * @since 2010-4-15 下午01:20:38
 */
public class EncodingFilter implements Filter {
	
	protected FilterConfig filterConfig = null;
    protected String encoding="";
    
	public void destroy() {
		this.filterConfig=null;
		this.encoding=null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(getEncoding()==null||"".equals(getEncoding())){
			setEncoding(request.getCharacterEncoding());
		}
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig=config;
		this.encoding=config.getInitParameter("Encoding");
		
	}
	
	public String getEncoding(){
		return this.encoding;
	}
	
	public void  setEncoding(String encoding){
		this.encoding=encoding;
	}
	
}
