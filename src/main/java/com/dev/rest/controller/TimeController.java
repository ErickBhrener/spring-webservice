package com.dev.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.rest.model.Membro;
import com.dev.rest.model.Time;
import com.dev.rest.repository.MembroRepository;
import com.dev.rest.repository.TimeRepository;

@BasePathAwareController
public class TimeController {

	private final TimeRepository timeRepo;
	private final MembroRepository membroRepo;
	private final PagedResourcesAssembler pagedResourcesAssembler;

	@Autowired
	public TimeController(TimeRepository timeRepository, MembroRepository membroRepository,
			PagedResourcesAssembler assembler) {
		this.timeRepo = timeRepository;
		this.membroRepo = membroRepository;
		this.pagedResourcesAssembler = assembler;
		this.timeRepo.save(new Time("alfa"));
		this.timeRepo.save(new Time("bravo"));
		this.timeRepo.save(new Time("charlie"));
	}

	@RequestMapping(value = "/time/filtrarPorNome", method = RequestMethod.GET)
	@ResponseBody
	public PagedResources<?> getByNome(@RequestParam("nome") String nome, Pageable pageable,
			PersistentEntityResourceAssembler entityAssembler) {
		Page<Membro> times = timeRepo.findByNomeStartsWith(nome.toLowerCase(), pageable);
		return pagedResourcesAssembler.toResource(times, entityAssembler);
	}

	@RequestMapping(value = "/time/{id}/novoMembro", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity addNovoMembro(@PathVariable("id") Long id, @RequestParam("membro") Long membroId) {
		Membro membro = membroRepo.findOne(membroId);
		Time time = timeRepo.findOne(id);
		if (membro != null && time != null) {
			if(time.getMembros().contains(membro))return new ResponseEntity<>("Membro ja esta no time", new HttpHeaders(), HttpStatus.CONFLICT);
			time.addMembro(membro);
			timeRepo.save(time);
			return new ResponseEntity<>("Membro adicionado",new HttpHeaders(), HttpStatus.OK);
		}
		return new ResponseEntity<>("Membro ou time nao encontrado", new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
