package command;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	public void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		String command = "";

		try {
			Method[] md = this.getClass().getMethods();
			command = request.getRequestURI();
			command = command.replace(".do", "");	// URI 뒤에 '.do' 삭제
			
			if (command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
				command = command.substring(command.lastIndexOf("/") + 1);	 	// URI 앞에 '/' 삭제
			}
			System.out.println("command : " + command);		// list
			
			for (int i = 0; i < md.length; i++) {
				if (md[i].getName().equals(command)) {
					view = (String) md[i].invoke(this, request, response);
					System.out.println("md : " + md[i].getName() + " = " + command);
				}
			}
			
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		
		if (view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			String exc = "public String " + command + "(HttpServletRequest request, HttpServletResponse response)"
					+ " throws Throwable { \n \t return \" \"; \n} \n 를 추가하세요";
			System.out.println(exc);
		}
	}
}
