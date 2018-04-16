package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */

@Service
public class ChamadoService {
	ChamadoDAO dao;

	@Autowired
	public ChamadoService(ChamadoDAO dao) {
		this.dao = dao;
	}

	public List<Chamado> listarChamados(Fila fila) throws IOException {
		return dao.listarChamados(fila);
	}

	public Chamado criarChamado(Chamado chamado) throws IOException {
		chamado.setStatus(Chamado.ABERTO);
		chamado.setDataAbertura(new Date());
		chamado.setDataFechamento(null);

		Chamado chamadoSalvo = dao.criar(chamado);

		return chamadoSalvo;
	}

	public Chamado fecharChamado(int id) throws IOException {
		Chamado chamado = dao.buscarPorId(id);

		chamado.setStatus(Chamado.FECHADO);
		chamado.setDataFechamento(new Date());

		Chamado chamadoFechado = dao.fechar(chamado);

		return chamadoFechado;

	}
//
//	public PaginaCliente consultarClientes() {
//		try {
//			URL jsonUrl = new URL("https://reqres.in/api/users?per_page=15&page=1");
//			ObjectMapper mapper = new ObjectMapper();
//			// Cliente cliente = mapper.readValue(jsonUrl, Cliente.class);
//
//			PaginaCliente paginaCliente = mapper.readValue(jsonUrl, PaginaCliente.class);
//
//			return paginaCliente;
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
