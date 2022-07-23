package br.com.proitec.legacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.proitec.legacy.model.Cliente;
import br.com.proitec.legacy.service.ClienteService;

@Controller
@RequestMapping(value = "pages")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	/*
	 * @GetMapping(value = "/consultar-clientes") public ModelMap findAll() {
	 * ModelMap model = new ModelMap();
	 * model.addAttribute("clientes",service.findAll()); return model; }
	 */

	@GetMapping(value = "/consultar-clientes") 
	public ModelAndView  findAll() {
		ModelAndView mv = new ModelAndView(); 
		mv.addObject("clientes",service.findAll());
		return mv; 
	}
	
	@RequestMapping(value = "/cadastrar-cliente", method = RequestMethod.GET) 
	public String decoratorAddCliente(Model model) { 
		model.addAttribute("cliente",new Cliente());
		return "pages/cadastrar-cliente"; 
	}

	@RequestMapping(value = "/cadastrar-cliente", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Cliente cliente) {

		//if (validate.hasErrors()) { 
		//ModelAndView mv = new  ModelAndView("pages/cadastrar-cliente"); 
		//return new  ModelAndView(); 
		//}

		service.save(cliente);

		return new ModelAndView("redirect:/pages/consultar-clientes");

	}
}