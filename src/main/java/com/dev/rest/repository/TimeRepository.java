package com.dev.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dev.rest.model.Time;

@RepositoryRestResource(path="time")
public interface TimeRepository extends PagingAndSortingRepository<Time, Long>{
	
	@Query("SELECT t FROM Time t  WHERE t.nome LIKE CONCAT('%',:nome,'%') ORDER BY t.nome ASC")
	Page findByNomeStartsWith(@Param("nome") String nome, Pageable p);
	
}
