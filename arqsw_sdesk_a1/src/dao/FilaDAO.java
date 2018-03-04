package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Fila;

public class FilaDAO {

	public ArrayList<Fila> listarFilas() throws IOException {
		String query = "SELECT ID_FILA, NM_FILA from FILA";
		ArrayList<Fila> lista = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				Fila fila = new Fila();
				fila.setId(rs.getInt("ID_FILA"));
				fila.setNome(rs.getString("NM_FILA"));
				
				lista.add(fila);
			}
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}

}
