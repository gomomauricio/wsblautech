package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.entity.UsuarioM;
import com.udemy.repository.UsuarioMRepository;

 

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioMServiceImpl.
 */
@Service
public class UsuarioMServiceImpl  {
	
	/** The repository. */
	@Autowired
	@Qualifier("usuarioMRepository")
	UsuarioMRepository repository;
	
	/**
	 * Guardar.
	 *
	 * @param entity the entity
	 * @return the usuario M
	 */
	public UsuarioM guardar(UsuarioM entity) {
		return repository.save(entity);
	}
	
	/**
	 * Borrar.
	 *
	 * @param entity the entity
	 * @return true, if successful
	 */
	public boolean borrar(UsuarioM entity)
	{
		try {
			repository.delete(entity);
			return true;
		} catch(Exception ex) {
			return false;
		}
	}
 
 	
	/**
	 * Actualizar.
	 *
	 * @param entity the entity
	 * @return the usuario M
	 */
	public UsuarioM actualizar(UsuarioM entity) {
		return repository.save(entity);
	}
	
	/**
	 * Consultar por id.
	 *
	 * @param id the id
	 * @return the usuario M
	 */
	public UsuarioM consultarPorId(Integer id ) {
		return repository.findById(id).orElse(null);
	}
	
	/**
	 * Consultar todos.
	 *
	 * @return the list
	 */
	public List<UsuarioM>consultarTodos() {
		return repository.findAll();
	}
}
