package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

//@WebServlet("/entrada") transformado em filter
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + parametroAcao;

		String nome;
		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse);
			@SuppressWarnings("deprecation")
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] endereco = nome.split(":");
		if (endereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + endereco[1]);
			rd.forward(request, response);

		} else {
			response.sendRedirect(endereco[1]);

		}

	}

}
