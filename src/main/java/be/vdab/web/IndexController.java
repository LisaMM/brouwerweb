package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/")
class IndexController {
	private final BrouwerService brouwerService;
	
	@Autowired
	public IndexController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("aantalBrouwers", brouwerService.findAantalBrouwers());
		return modelAndView ;
	}
}