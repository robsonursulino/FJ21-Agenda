package br.com.caelum.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
