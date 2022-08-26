package br.com.proitec.legacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.proitec.legacy.model.Cliente;
import br.com.proitec.legacy.service.ClienteService;

@Controller
@RequestMapping(value = "pages")
public class ReservaController {

	@Autowired
	private ClienteService service;
	
	//@GetMapping(value = "reservar-veiculo")
	public ModelMap reserva() {
		return new ModelMap();
    }

	//@RequestMapping(value = "/reservar-veiculo", method = RequestMethod.GET) 
	public String decoratorAdd(Model model) { 
		model.addAttribute("cliente",new Cliente());
		return "pages/reservar-veiculo"; 
	}

	@RequestMapping(value = "/reservar-veiculo", method = RequestMethod.GET) 
	public ModelAndView  findAll() {
		return new ModelAndView().addObject("clientes",service.findAll());
	}

}