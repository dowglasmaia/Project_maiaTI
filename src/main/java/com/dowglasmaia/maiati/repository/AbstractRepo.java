package com.dowglasmaia.maiati.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dowglas Maia 
 * Skype: live:dowglasmaia 
 * E-mail:dowglasmaia@live.com
 *Linkedin: www.linkedin.com/in/dowglasmaia
 * 
 *Repositorio Generico
 * 
 */

@Repository
public abstract class AbstractRepo<T, PK extends Serializable> {

	// Metodo auxilar para Consultas Genericas, Recuperando a Class de Instancia
	@SuppressWarnings("unchecked")
	private final Class<T> entidadeClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	/* Instanciando um EntityManager */
	@PersistenceContext
	protected EntityManager manager;

	public EntityManager getManager() {
		return manager;
	}

	/* salvar */
	@Transactional(rollbackFor = { Exception.class })
	public T save(T obj) {
		manager.persist(obj);
		return obj;
	}

	/* Atualizar */
	@Transactional(rollbackFor = { Exception.class })
	public T update(T obj) {
		manager.merge(obj);
		return obj;
	}

	/* Deletar */
	@Transactional(rollbackFor = { Exception.class })
	public void delete(PK id) {
		manager.remove(manager.getReference(entidadeClass, id));
	}

	/* Buscar por ID */
	public T findById(PK id) {
		return manager.find(entidadeClass, id);
	}

	/* Buscar Todos */
	public List<T> findAll() {
		return manager.createQuery("from " + entidadeClass.getSimpleName(), entidadeClass).getResultList();
	}

	/* Consultar Dinamica */
	protected List<T> createDinamicQuery(String jpql, Object... params) {
		TypedQuery<T> query = manager.createQuery(jpql, entidadeClass);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		return query.getResultList();
	}

}
