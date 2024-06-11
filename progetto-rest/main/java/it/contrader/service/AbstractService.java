package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import it.contrader.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Questa classe astratta implementa tutti i metodi CRUD firmati in ServiceDTO.
 * Il converter agisce due volte nei metodi  insert e update per avere sia come input che come output
 * un oggetto DTO.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @param <Entity>
 * @param <DTO>
 * 
 * @see ServiceDTO
 */

public abstract class AbstractService<Entity,DTO> implements ServiceDTO<DTO> {
	
	@Autowired
	protected CrudRepository<Entity,Long> repository;
	@Autowired
	protected Converter<Entity,DTO> converter;
	@Autowired
	protected JpaRepository<Entity, Long> jpaRepository;
	
	@Override
	public DTO insert(DTO dto) {
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}

	@Override
	public List<DTO> getAll() {
		return converter.toDTOList((List<Entity>) repository.findAll());
	}

	@Override
	public DTO read(long id) {
		return converter.toDTO(repository.findById(id).get());
	}

	@Override
	public DTO update(DTO dto) {
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}

	@Override
	public Page<DTO> toDtoPage(Pageable page) { return converter.toDtoPage(jpaRepository.findAll(page)); }

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

}