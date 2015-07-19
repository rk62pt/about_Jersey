package tw.com.rk62pt.jersey.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharactorFilter implements Filter {

	//字元編碼

	String encoding=null;


	public void doFilter(ServletRequest request, ServletResponse response,

	FilterChain chain) throws IOException, ServletException {

	if(encoding!=null){

	//設置request字元編碼

	request.setCharacterEncoding(encoding);

	//設置response字元編碼

	response.setContentType("text/html;charset="+encoding);

	}

	//傳遞給下一個過濾器

	chain.doFilter(request, response);


	}


	public void init(FilterConfig filterConfig) throws ServletException {

	//獲取初始化參數

	encoding=filterConfig.getInitParameter("encoding");


	}


	public void destroy() {

	// TODO Auto-generated method stub

	encoding=null;

	}

}
