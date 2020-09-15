package sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;

public class SampleHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setAttribute("samplehello", "»ùÇÃÇï·Î¿ìÀÔ´Ï´Ù.");
		return "/WEB-INF/view/sample.jsp";
	}

}
