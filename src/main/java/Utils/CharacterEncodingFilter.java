package Utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Struts 1.3.10 encoding problem
 * 
 * @see http://www.coderanch.com/t/557874/Struts/Struts-encoding
 */
public class CharacterEncodingFilter implements Filter { 
	
    @Override
    public void destroy() {
        System.out.println("destroy calisti ");
        
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req; 
        HttpServletResponse response = (HttpServletResponse) resp; 

        request.setCharacterEncoding("UTF8"); 
        response.setCharacterEncoding("UTF8"); 

        chain.doFilter(request, response); 

        request.setCharacterEncoding("UTF8"); 
        response.setCharacterEncoding("UTF8"); 
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}