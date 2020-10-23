package search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	
	@RequestMapping("/search")
	public String search(@RequestParam(value = "q", defaultValue = "aaa") String query, Model model) {
		System.out.println("검색어 : " + query);
		return "search/result";
	}
	
	@RequestMapping("/search2")
	public String search2(@RequestParam(value = "q", defaultValue = "15") int num, Model model) {
		System.out.println("검색어 : " + num);
		model.addAttribute("q", num);
		return "search/result";
	}
}
