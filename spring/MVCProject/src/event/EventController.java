package event;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/event")
public class EventController {
	private static final String REDIRECT_EVENT_LIST = "redirect:/event/list";
	private EventService eventService;
	
	public EventController() {
		eventService = new EventService();
	}
	@RequestMapping("/list")
	public String list(SearchOption option, Model model) {
		List<Event> eventList = eventService.getOpenedEventList(option);
		model.addAttribute("eventList", eventList);
		model.addAttribute("eventTypes", EventType.values());
		return "event/list";
	}
	
	@RequestMapping("/list2")
	public ModelAndView list2(SearchOption option) {
		List<Event> eventList = eventService.getOpenedEventList(option);
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("event/list");
		modelView.addObject("eventList", eventList);
		modelView.addObject("eventTypes", EventType.values());
		return modelView;
	}
}
