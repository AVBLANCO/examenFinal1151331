package com.ufps.interfaceService;

import java.util.List;
import java.util.Optional;

import javax.persistence.Persistence;

import com.ufps.modelo.Usuario;

public interface IUsuarioService {
	public List<Usuario> listar();
	public Optional<Usuario> listarId(int id);
	public int save(Usuario p);
	public void delete(int id);

}
