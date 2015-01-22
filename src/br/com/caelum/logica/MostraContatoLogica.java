package br.com.caelum.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;


public class MostraContatoLogica implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		long id = Long.parseLong(req.getParameter("id"));
		
		Connection connection = (Connection) req.getAttribute("connection");
		
		Contato contato = new ContatoDAO(connection).seleciona(id);
		
		req.setAttribute("contato", contato);
		
		return "/WEB-INF/jsp/edita-contato.jsp";
	
	}

}
