package com.ufps.interfaceService;

import java.util.List;

import javax.persistence.Persistence;

public interface IusuarioService {
	public List<Usuario> listar();
	public Optional<Usuario> listarId(int id);
	public int save(Usuario p);
	public void delete(int id);

}
