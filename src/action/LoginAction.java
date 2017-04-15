package action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String password;
	private String username;
	private String tip;
	private HttpServletResponse response;

	@Override
	public String execute() throws Exception {

		ActionContext ctx = ActionContext.getContext();
		Integer counter = (Integer) ctx.getApplication().get("counter");
		if (counter == null) {
			counter = 1;
		} else {
			counter += 1;
		}
		ctx.getApplication().put("counter", counter); // application
		ctx.getSession().put("user", getUsername()); // session
		if (getUsername() == null && getPassword() == null) {
			return INPUT;
		}
		if (getUsername().equals("admin") && getPassword().equals("admin")) {
			ctx.put("tip", "服务器提示：您已经成功登陆!"); // request
			return SUCCESS;
		} else {
			ctx.put("tip", "服务器提示：登陆失败!"); // request
			return ERROR;
		}
	}

	public void write() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		/*
		 * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码),
		 * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会
		 * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。
		 */
		response.setContentType("text/html;charset=utf-8");
		// response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试
		String jsonString = "{\"user\":{\"id\":\"123\",\"name\":\"张三\",\"say\":\"Hello , i am a action to print a json!\",\"password\":\"JSON\"},\"success\":true}";
		out.println(jsonString);
		out.flush();
		out.close();
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
