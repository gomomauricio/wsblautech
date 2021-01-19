package com.udemy.repository;

import java.io.Serializable;

 
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
 
import com.udemy.entity.UsuarioM;

/**
 * The Interface UsuarioMRepository.
 */
@Repository("usuarioMRepository")
public interface UsuarioMRepository extends MongoRepository<UsuarioM, Serializable>
{

//	public abstract Contact findById( Integer id);
	
}
