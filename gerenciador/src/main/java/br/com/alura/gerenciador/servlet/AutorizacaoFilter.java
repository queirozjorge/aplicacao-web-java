package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/entrada") definido pelo web.xml
public class AutorizacaoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String parametroAcao = req.getParameter("acao");
		HttpSession sessao = req.getSession();
		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean eUmaAcaoProtegida = !(parametroAcao.equals("Login") || parametroAcao.equals("LoginForm"));

		if (eUmaAcaoProtegida && usuarioNaoEstaLogado) {
			resp.sendRedirect("entrada?acao=LoginForm");
			return;
		}

		System.out.println("Autorizado!");
		chain.doFilter(request, response);
	}

}
