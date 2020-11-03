package acl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AclController {
	@Autowired
	private AclService aclService;
	
	@RequestMapping("/acl/list")
	public String list(Model model) {
		model.addAttribute("aclList", aclService.getAclList());
		return "acl/acList";
	}
	
	public void setAclService(AclService aclService) {
		this.aclService = aclService;
	}
}
