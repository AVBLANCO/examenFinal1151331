package com.ufps.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.ufps.modelo.Usuario;

public interface IUsuario extends CrudRepository<Usuario,Integer>{

	
}

