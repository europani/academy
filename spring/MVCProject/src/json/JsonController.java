package json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

	@RequestMapping(value = "/str", produces = "application/json;charset=UTF-8")
	public String str() {
		return "str aaaa";
	}

	@RequestMapping("/json")
	public List<String> json() {
		List<String> li = new ArrayList<String>();
		
		li.add("111");
		li.add("222");
		li.add("333");
		return li;
	}


}
