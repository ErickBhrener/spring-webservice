package com.dev.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.dev.rest.model.Membro;

@RepositoryRestResource(path="membro")
public interface MembroRepository extends PagingAndSortingRepository<Membro, Long> {

	@Query("SELECT m FROM Membro m WHERE LOWER(m.nome) LIKE CONCAT('%',:nome,'%') ORDER BY m.nome ASC")
	Page<Membro> findByNomeStartsWith(@Param("nome") String nome, Pageable p);
	
}
