package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
	private final BrouwerService brouwerService;
	private final char[] alfabet;

	@Autowired
	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		alfabet = new char['Z' - 'A' + 1];
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			alfabet[letter - 'A'] = letter;
		}
	}

	@RequestMapping
	public ModelAndView brouwers() {
		return new ModelAndView("brouwers/brouwers", "brouwers",
				brouwerService.findAll());
	}

	@RequestMapping("opnaam")
	public String opNaam() {
		return "brouwers/opnaam";
	}

	@RequestMapping("toevoegen")
	public String toevoegen() {
		return "brouwers/toevoegen";
	}

	@RequestMapping(value = "opalfabet", method = RequestMethod.GET)
	public ModelAndView opAlfabetForm() {
		return new ModelAndView("brouwers/opalfabet", "alfabet", alfabet);
	}

	@RequestMapping(method = RequestMethod.GET, params = "letter")
	public ModelAndView opAlfabet(@RequestParam char letter) {
		ModelAndView modelAndView = new ModelAndView("brouwers/opalfabet");
		modelAndView.addObject("alfabet", alfabet);
		modelAndView.addObject("brouwers",
				brouwerService.findByNaam(String.valueOf(letter)));
		return modelAndView;
	}
	
	@RequestMapping(value = "opnaam", method = RequestMethod.GET)
	public ModelAndView opNaamForm() {
		return new ModelAndView("brouwers/opnaam", "brouwersOpNaamForm", 
			new BrouwersOpNaamForm());
	}
	
	@RequestMapping(method = RequestMethod.GET, params="beginnaam")
	public ModelAndView opNaam(@Valid BrouwersOpNaamForm brouwersOpNaamForm, 
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("brouwers/opnaam");
		if (! bindingResult.hasErrors()) {
			modelAndView.addObject("brouwers", 
					brouwerService.findByNaam(brouwersOpNaamForm.getBeginnaam()));
		}
		return modelAndView;
	}
}
