package br.com.caelum.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class AdicionaContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		// Busca os parâmetros do request.
		String nome = req.getParameter("nome_contato");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataNascimentoTexto = req.getParameter("data_nascimento");

		// Converte a data para Calendar
		Calendar dataNascimento = null;
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// Monta um objeto do tipo contato
		Contato contato = new Contato();
		contato.setNome_contato(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setData_nascimento(dataNascimento);
		
		// Salva o contato.
		Connection connection = (Connection) req.getAttribute("connection");
		ContatoDAO contatoDAO = new ContatoDAO(connection);
		contatoDAO.adiciona(contato);
		
		return "mvc?logica=ListaContatosLogica";
	}

}
