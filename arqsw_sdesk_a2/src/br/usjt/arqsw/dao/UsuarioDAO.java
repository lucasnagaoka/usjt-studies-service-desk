package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

@Repository
public class UsuarioDAO {
	private Connection conn;

	@Autowired
	public UsuarioDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

	public Usuario validar(Usuario usuario) throws IOException {
		Usuario novoUsuario = null;
		// usuario.setUsername(username);
		// usuario.setPassword(password);

		String query = "select USERNAME, PASSWORD from USUARIO where USERNAME=?";

		try (PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setString(1, usuario.getUsername());
			try (ResultSet rs = pst.executeQuery();) {

				if (rs.next()) {
					novoUsuario = new Usuario();
					novoUsuario.setUsername(rs.getString("USERNAME"));
					novoUsuario.setPassword(rs.getString("PASSWORD"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		return novoUsuario;
	}
}
