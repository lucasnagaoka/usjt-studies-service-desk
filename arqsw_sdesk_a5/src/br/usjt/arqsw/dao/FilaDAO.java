package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */

@Repository
public class FilaDAO {
	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Fila> listarFilas() throws IOException {
		return manager.createQuery("select fila from Fila fila").getResultList();
	}

	public Fila carregar(int id) throws IOException {
		return manager.find(Fila.class, id);
	}

	public Fila salvar(Fila fila) throws IOException {
		manager.persist(fila);
		return this.carregar(fila.getId());
	}

	public boolean excluir(Fila fila) {
		manager.remove(fila);
		return true;
	}

	public Fila atualizar(Fila fila) throws IOException {
		manager.merge(fila);
		return this.carregar(fila.getId());
	}
}
