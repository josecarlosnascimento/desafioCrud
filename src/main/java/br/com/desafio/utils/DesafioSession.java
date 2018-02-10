package br.com.desafio.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DesafioSession implements Filter {

	  public void destroy() {
	         // TODO Auto-generated method stub
	   
	      }
	  
	  public void init(FilterConfig arg0) throws ServletException {
	         // TODO Auto-generated method stub
	   
	      }
	
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		HttpSession ss =  ((HttpServletRequest) arg0).getSession(true);
		System.out.println(ss);
		
	}


}
