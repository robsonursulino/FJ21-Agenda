package br.com.caelum.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class RemoveContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Connection connection = (Connection) req.getAttribute("connection");
		
		Contato contato = new Contato();
		contato.setCod_contato(id);
		
		ContatoDAO contatoDAO = new ContatoDAO(connection);
		contatoDAO.remove(contato);
		
		System.out.println("Removendo contato...");
		
		return "mvc?logica=ListaContatosLogica";
		
	}

}
