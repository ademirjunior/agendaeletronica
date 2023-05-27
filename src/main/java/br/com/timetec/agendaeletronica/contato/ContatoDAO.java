package br.com.timetec.agendaeletronica.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {

	private static final String INSERT_SQL = "INSERT INTO CONTATO (NOME, EMAIL, TELEFONE) VALUES (?, ?, ?)";
	private Connection conexao;

	public ContatoDAO(Connection conexao) {
		// TODO Auto-generated constructor stub
		this.conexao = conexao;
	}
	
	public void inserir(Contato contato) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT_SQL);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getTelefone());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}

	}

}
