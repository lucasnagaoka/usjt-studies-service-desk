package br.usjt.arqsw.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.UsuarioDAO;
import br.usjt.arqsw.entity.Usuario;

@Service
public class UsuarioService {
	private UsuarioDAO dao;

	@Autowired
	public UsuarioService(UsuarioDAO dao) {
		this.dao = dao;
	}

	public Usuario validar(Usuario usuario) throws IOException {
		Usuario novoUsuario = dao.validar(usuario);

		if (novoUsuario != null && novoUsuario.getPassword().equals(usuario.getPassword())) {
			return novoUsuario;
		}

		return null;

	}

}
