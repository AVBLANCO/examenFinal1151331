package com.ufps.controller;
import com.ufps.interfaceService.IUsuarioService;
import com.ufps.modelo.Usuario;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class Controlador {

	 @Autowired
		private IUsuarioService service; 
		
	    @GetMapping("/listar")
		public String listar (Model model) {
			List<Usuario> usuario=service.listar();
			model.addAttribute("personas",usuario);
			return "index";
		}
	    
	    //mapeo a la vista Login
	    @GetMapping("/")
	   	public String listar2 (Model model) {
	   		return "Login";
	   	}
	    @GetMapping("/registro")
	   	public String registrar (Model model) {
	   		return "Registro";
	   	}
	   
	    @GetMapping("/new")
	    public String agregar(Model model) {
	    	model.addAttribute("usuario", new Usuario());
	    	return "Form";
	    }
	    
	    @PostMapping("/save")
	    public String save(@Validated Usuario u,Model model ) {
	    	service.save(u);
	    	return "redirect:/listar";
	    }
	    
	    @GetMapping("/editar/{id}")
	    public String editar(@PathVariable int id, Model model) {
	    	Optional<Usuario> usuario=service.listarId(id);
	    	model.addAttribute("usuario",usuario);
	    	return "Form";
	    }
	    @GetMapping("/eliminar/{id}")
	    public String delete(Model model, @PathVariable int id) {
	    	service.delete(id);
	    	return "redirect:/listar";
	    }
	    
	    

		@GetMapping("/login")
		public String login(@RequestParam(value="error", required=false) String error,
				@RequestParam(value="logout", required = false) String logout,
				Model model, Principal principal, RedirectAttributes flash) {
			
			if(principal != null) {
				flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
				return "redirect:/";
			}
			
			if(error != null) {
				model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
			}
			
			if(logout != null) {
				model.addAttribute("success", "Ha cerrado sesión con éxito!");
			}
			
			return "login";
		}
	    
	}