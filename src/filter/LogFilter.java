package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(filterName = "/LogFilter",urlPatterns="/*")
public class LogFilter implements Filter {

	//FilterConfig用于访问Filter的配置信息
	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public LogFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		long before = System.currentTimeMillis();
        System.out.println("开始过滤...");
        HttpServletRequest hRequest = (HttpServletRequest) request;
        System.out.println("Filter已经截获到用户的请求地址:" + hRequest.getServletPath());
		// pass the request along the filter chain
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		System.out.println("过滤结束...");
		System.out.println("请求被定位到：" + hRequest.getRequestURI() + "所花费时间：" + (after - before));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}
}
