package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Lucas Nagaoka
 *
 */

public class ChamadoService {

	private ChamadoDAO dao;

	public ChamadoService() {
		dao = new ChamadoDAO();
	}

	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException {
		return dao.listarChamados(fila);
	}

	public Chamado criarChamado(Chamado chamado) throws IOException {
		chamado.setStatus(Chamado.ABERTO);
		chamado.setDataAbertura(new Date());

		Chamado chamadoSalvo = dao.criarChamado(chamado);

		return chamadoSalvo;
	}

}
