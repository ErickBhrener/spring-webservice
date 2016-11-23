package com.dev.rest.model;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="details",types={Time.class})
interface MembrosProjection {
	String getNome();
	List<Membro> getMembros();
}
