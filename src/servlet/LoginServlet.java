package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="/LoginServlet",urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errMsg = "";
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		RequestDispatcher rd;
		if(username.equals("admin") && pass.equals("admin")){
			request.setAttribute("username", username);
			request.getRequestDispatcher("/jsp/welcome.jsp").forward(request, response);
		}else{
			errMsg = "您输入的用户名或密码不匹配！";
		}
		if(errMsg!=null && !errMsg.equals("")){
			rd = request.getRequestDispatcher("/jsp/login.jsp");
			request.setAttribute("err", errMsg);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
