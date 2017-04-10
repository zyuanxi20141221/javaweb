package action;

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
            counter +=1;
		}
        ctx.getApplication().put("counter", counter); //application
        ctx.getSession().put("user", getUsername());  //session
		if (getUsername() == null && getPassword() == null) {
			return INPUT;
		}
		if (getUsername().equals("admin") && getPassword().equals("admin")) {
			ctx.put("tip", "服务器提示：您已经成功登陆!"); //request
			return SUCCESS;
		} else {
			ctx.put("tip", "服务器提示：登陆失败!"); //request
			return ERROR;
		}
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
