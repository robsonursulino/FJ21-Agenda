package br.com.caelum.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Calendar dataNascimento = null;
		
		// Busca os parâmetros do request.
		String nome = request.getParameter("nome_contato");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataNascimentoTexto = request.getParameter("data_nascimento");
		System.out.println(dataNascimentoTexto);
		// Converte a data para Calendar
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
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.adiciona(contato);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/contato-adicionado.jsp");
		dispatcher.forward(request, response);
		
	}	
}
