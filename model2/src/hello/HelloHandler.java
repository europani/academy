package hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;

public class HelloHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setAttribute("hello", "æ»≥Á«œººø‰!");
		return "/WEB-INF/view/hello.jsp";
	}
}
