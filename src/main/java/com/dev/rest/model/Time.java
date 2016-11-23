package com.dev.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Time {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinTable(name = "time_membro", joinColumns = @JoinColumn(name = "time_pk"),
    inverseJoinColumns = @JoinColumn(name = "membro_pk"))
	private List<Membro> membros;
	
	public Time(String nome) {
		super();
		this.nome = nome;
	}

	public Time() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Membro> getMembros() {
		return membros;
	}

	public void addMembro(Membro membro) {
		if(this.membros == null){
			this.membros = new ArrayList<>();
		}
		this.membros.add(membro);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + ", membros=" + membros + "]";
	}
	
	
	
}
