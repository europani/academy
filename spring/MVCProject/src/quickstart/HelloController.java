package quickstart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public String hello(Model model) {
		model.addAttribute("greeting", "안녕하세요");
		return "hello";
	}
	@RequestMapping("/hello2.do")
	public void hello2(HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("안녕하세요");
		writer.flush();
	}
	@RequestMapping("/hello.do2")
	public String hello2(Model model) {
		model.addAttribute("greeting", "반갑습니다");
		return "hello";
	}

}
