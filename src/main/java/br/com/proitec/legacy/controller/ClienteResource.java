package br.com.proitec.legacy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.proitec.legacy.enderecows.EnderecoConsumer;
import br.com.proitec.legacy.model.Cliente;
import br.com.proitec.legacy.model.EnderecoWS;
import br.com.proitec.legacy.service.ClienteService;

@Controller
@RequestMapping(value = "pages")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@Autowired
	private EnderecoConsumer enderecoConsumer;
	
	@RequestMapping(value = "/consultar-clientes", method = RequestMethod.GET) 
	public ModelAndView  findAll() {
		return new ModelAndView().addObject("clientes",service.findAll());
	}
	
    @PostMapping(value = "/cadastrar-cliente")
	public ModelAndView save(@Valid Cliente cliente, BindingResult validate, RedirectAttributes attributes) {

		if (validate.hasErrors()) { 
		return new  ModelAndView("pages/cadastrar-cliente"); 
		}
     	service.save(cliente);
		attributes.addFlashAttribute("message", "Cliente salvo com sucesso!");
		return new ModelAndView("redirect:/pages/consultar-clientes");
	}

	@GetMapping(value = "/excluir-cliente/{id}") 
	public ModelAndView delete(@PathVariable Long id, RedirectAttributes attributes) {
        service.delete(id);
		attributes.addFlashAttribute("message", "Cliente excluído com sucesso!"); 
		return new ModelAndView("redirect:/pages/consultar-clientes");
	}

	@ResponseBody
	@RequestMapping(value = "/editar-cliente", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("cep") String cep, Long id, Cliente cliente, RedirectAttributes attributes, BindingResult validate) {
        
		if (validate.hasErrors()) {
			cliente.setIdentificador(id);
			new ModelAndView("redirect:/pages/consultar-clientes");
		}
		
		EnderecoWS endereco = enderecoConsumer.enderecoConsumer(cep);
		cliente.setEndereco(endereco);
		
		service.update(id, cliente);
		attributes.addFlashAttribute("message", "Alteração efetuada com sucesso!");
		return new ModelAndView("redirect:/pages/consultar-clientes");
    }
	
	@ResponseBody
	@GetMapping(value = "/editar-cliente")
	public Cliente decoratorEdit(Long id, Model model) {
	    return service.findById(id);
	}
	
	@RequestMapping(value = "/cadastrar-cliente", method = RequestMethod.GET) 
	public String decoratorAdd(Model model) { 
		model.addAttribute("cliente",new Cliente());
		return "pages/cadastrar-cliente"; 
	}
}