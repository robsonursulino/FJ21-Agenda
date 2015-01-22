package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Contato;

public class ContatoDAO {
	
	private Connection conexaoBD;
	
	public ContatoDAO() {
		this.conexaoBD = ConnectionFactory.getConnection();
	}
	
	public ContatoDAO(Connection connection) {
		this.conexaoBD = connection;
	}
	
	public void adiciona(Contato contato) {
		
		String sql = "insert into contato(nome_contato, email, endereco, data_nascimento) values(?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conexaoBD.prepareStatement(sql);
			stmt.setString(1, contato.getNome_contato());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getData_nascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		}	
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato) throws SQLException {
		String sql = "update contato set nome_contato=?, email=?, endereco=?, data_nascimento=? where cod_contato=?";
		PreparedStatement stmt = conexaoBD.prepareStatement(sql);
		stmt.setString(1, contato.getNome_contato());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new Date(contato.getData_nascimento().getTimeInMillis()));
		stmt.setLong(5, contato.getCod_contato());
		stmt.execute();
		stmt.close();
	}
	
	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = conexaoBD.prepareStatement("delete from contato where cod_contato=?");
			stmt.setLong(1, contato.getCod_contato());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Contato seleciona(long id) {
		try {
			PreparedStatement stmt = conexaoBD.prepareStatement("select * from contato where cod_contato=?");
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Contato contato = new Contato();

			if (rs.next()) {
				contato.setCod_contato(rs.getLong("cod_contato"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setNome_contato(rs.getString("nome_contato"));
				
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("data_nascimento"));
				
				contato.setData_nascimento(dataNascimento);
			}	
			
			rs.close();
			stmt.close();
			
			return contato;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista() {
		try {
			String sql = "select * from contato";
			
			PreparedStatement stmt = conexaoBD.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Contato> contatos = new ArrayList<Contato>(); 
			
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setCod_contato(rs.getLong("cod_contato"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setNome_contato(rs.getString("nome_contato"));
				
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("data_nascimento"));
				
				contato.setData_nascimento(dataNascimento);
				
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
