package com.dev.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.rest.model.Membro;
import com.dev.rest.repository.MembroRepository;

@BasePathAwareController
public class MembroController {
	
	private final MembroRepository membroRepo;
	private final PagedResourcesAssembler pagedResourcesAssembler;
	
	@Autowired
	public MembroController(MembroRepository membroRepo, PagedResourcesAssembler assembler){
		this.membroRepo = membroRepo;
		this.pagedResourcesAssembler = assembler;
	}
	@RequestMapping(value="/membro/filtrarPorNome",method = RequestMethod.GET)
	@ResponseBody
	public PagedResources<?> getByNome(@RequestParam("nome") String nome, Pageable pageable, PersistentEntityResourceAssembler entityAssembler){
		Page<Membro> membros = membroRepo.findByNomeStartsWith(nome.toLowerCase(), pageable);
		return pagedResourcesAssembler.toResource(membros,entityAssembler);
	}
	
}
