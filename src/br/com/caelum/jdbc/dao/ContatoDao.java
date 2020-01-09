package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos " +
				"(nome,email,endereco,dataNascimento)" +
				" values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDatanascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where nome like 'C%'");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setId(rs.getLong("id"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDatanascimento(data);
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public Contato pesquisarContato(int id) {
		String sql = "select * from contatos where id=" + id;

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			Contato contato = new Contato();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDatanascimento(data);
			}
			rs.close();
			stmt.close();
			return contato;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void alteraContato(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?,"
				+ "dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDatanascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void excluirContato(Integer id) {
		String sql = "delete from contatos where id=?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
}
