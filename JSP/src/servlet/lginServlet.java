package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getpost/loginServlet")
public class lginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public lginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		
		if (id!=null && pw != null) {
			HttpSession session = request.getSession();
			session.setAttribute("idKey", id);
			session.setMaxInactiveInterval(60*3);
		}
		response.sendRedirect("/jsp/getpost/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
