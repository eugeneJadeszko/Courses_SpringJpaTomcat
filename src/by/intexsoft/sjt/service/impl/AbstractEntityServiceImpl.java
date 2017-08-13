package by.intexsoft.sjt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.sjt.entity.AbstractEntity;
import by.intexsoft.sjt.service.AbstractEntityService;

public class AbstractEntityServiceImpl<T extends AbstractEntity> implements AbstractEntityService<T> {

	@Autowired
	JpaRepository<T, Long> repository;

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public T findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public T deleteById(Long id) {
		T entity = repository.findOne(id);
		if (!entity.equals(null)) {
			repository.delete(entity);
		}
		return entity;
	}
}