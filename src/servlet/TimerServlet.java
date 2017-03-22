package servlet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class TimerServlet
 */
@WebServlet(name="TimerServlet", loadOnStartup=1)
public class TimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init");
		javax.swing.Timer t = (javax.swing.Timer) new javax.swing.Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(new Date());
			}
		});
		t.start();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimerServlet() {
        super();
    }
}
