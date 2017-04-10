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

	//FilterConfig���ڷ���Filter��������Ϣ
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
        System.out.println("��ʼ����...");
        HttpServletRequest hRequest = (HttpServletRequest) request;
        System.out.println("Filter�Ѿ��ػ��û��������ַ:" + hRequest.getServletPath());
		// pass the request along the filter chain
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		System.out.println("���˽���...");
		System.out.println("���󱻶�λ����" + hRequest.getRequestURI() + "������ʱ�䣺" + (after - before));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}
}
