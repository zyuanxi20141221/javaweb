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
			ctx.put("tip", "��������ʾ�����Ѿ��ɹ���½!"); // request
			return SUCCESS;
		} else {
			ctx.put("tip", "��������ʾ����½ʧ��!"); // request
			return ERROR;
		}
	}

	public void write() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		/*
		 * �ڵ���getWriter֮ǰδ���ñ���(�ȵ���setContentType����setCharacterEncoding�������ñ���),
		 * HttpServletResponse��᷵��һ����Ĭ�ϵı���(��ISO-8859-1)�����PrintWriterʵ���������ͻ�
		 * ����������롣�������ñ���ʱ�����ڵ���getWriter֮ǰ����,��Ȼ����Ч�ġ�
		 */
		response.setContentType("text/html;charset=utf-8");
		// response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// JSON�ڴ��ݹ���������ͨ�ַ�����ʽ���ݵģ������ƴ��һ��������
		String jsonString = "{\"user\":{\"id\":\"123\",\"name\":\"����\",\"say\":\"Hello , i am a action to print a json!\",\"password\":\"JSON\"},\"success\":true}";
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
