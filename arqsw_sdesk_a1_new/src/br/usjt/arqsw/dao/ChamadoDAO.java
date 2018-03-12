package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Lucas Nagaoka
 *
 */

public class ChamadoDAO {

	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException {
		String query = "select ID_CHAMADO, DESCRICAO, STATUS, DT_ABERTURA, DT_FECHAMENTO from CHAMADO where ID_FILA = ?;";
		ArrayList<Chamado> lista = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);) {

			pst.setInt(1, fila.getId());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setId(rs.getInt("ID_CHAMADO"));
				chamado.setDescricao(rs.getString("DESCRICAO"));
				chamado.setStatus(rs.getString("STATUS"));
				chamado.setDataAbertura(new java.util.Date(rs.getDate("DT_ABERTURA").getTime()));
				chamado.setDataFechamento(
						rs.getDate("DT_FECHAMENTO") != null ? new java.util.Date(rs.getDate("DT_FECHAMENTO").getTime())
								: null);
				chamado.setFila(fila);
				lista.add(chamado);
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}

	public int criarChamado(Chamado chamado) throws IOException {
		Date dataAbertura = new Date(chamado.getDataAbertura().getTime());

		return 0;
	}

}
