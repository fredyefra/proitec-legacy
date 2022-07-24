package br.com.proitec.legacy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.proitec.legacy.model.Cliente;
import br.com.proitec.legacy.service.ClienteService;

@Controller
@RequestMapping(value = "pages")
public class ClienteResource {

	@Autowired
	private ClienteService service;

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
	public ModelAndView save(@Valid Cliente cliente, BindingResult validate, RedirectAttributes attributes) {

		if (validate.hasErrors()) { 
		ModelAndView mv = new  ModelAndView("pages/cadastrar-cliente"); 
		return   mv; 
		}

		service.save(cliente);
		attributes.addFlashAttribute("message", "Cliente salvo com sucesso!");

		return new ModelAndView("redirect:/pages/consultar-clientes");
	}
}