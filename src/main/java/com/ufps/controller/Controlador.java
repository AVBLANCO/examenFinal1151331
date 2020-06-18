package com.ufps.controller;

public class Controlador {

	 @Autowired
		private IUsuarioService service; 
		
	    @GetMapping("/listar")
		public String listar (Model model) {
			List<Usuario> usuario=service.listar();
			model.addAttribute("personas",usuario);
			return "index";
		}
	    
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
	    
	    
	}