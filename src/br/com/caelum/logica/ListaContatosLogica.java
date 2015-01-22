package br.com.caelum.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class ListaContatosLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		Connection connection = (Connection) req.getAttribute("connection");
		
		List<Contato> contatos = new ContatoDAO(connection).getLista();
		
		req.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
