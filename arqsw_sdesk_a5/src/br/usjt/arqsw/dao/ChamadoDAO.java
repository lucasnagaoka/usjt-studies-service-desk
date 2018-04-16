package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */

@Repository
public class ChamadoDAO {
	@PersistenceContext
	EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Chamado> listarChamados(Fila fila) throws IOException {
		return manager.createQuery("select c from Chamado c where c.fila.id = ?").setParameter(1, fila.getId())
				.getResultList();
	}
	
	public Chamado buscarPorId(int id) {
		return manager.find(Chamado.class, id);
	}

	public Chamado criar(Chamado chamado) throws IOException {
		manager.persist(chamado);
		return obterUltimoChamado();
	}
	
	public Chamado fechar(Chamado chamado) throws IOException {
		manager.persist(chamado);
		return buscarPorId(chamado.getId());
	}

	private Chamado obterUltimoChamado() throws IOException {
		return (Chamado) manager.createQuery("select chamado from Chamado chamado order by chamado.id desc")
				.setMaxResults(1).getSingleResult();
	}
}
