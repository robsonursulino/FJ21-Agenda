package br.com.caelum.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		try {
			System.out.println("Conectando...");
			
			Connection connection = ConnectionFactory.getConnection();
		
			request.setAttribute("connection", connection);
		
			chain.doFilter(request, response);
		
			connection.close();
			
			System.out.println("Desconectando...");
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
