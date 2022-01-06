package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("Alterando dados da empresa.");
		String nomeEmpresa = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String data = request.getParameter("data");
		Integer id = Integer.parseInt(request.getParameter("id"));

		Date dataAbertura;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Banco banco = new Banco();
		Empresa empresa = banco.buscarEmpresaPorId(id);
		if (empresa == null) {
			response.sendRedirect("entrada?acao=ListaEmpresas");
		}

		empresa.setNome(nomeEmpresa);
		empresa.setCnpj(cnpj);
		empresa.setData(dataAbertura);

		return "redirect:entrada?acao=ListaEmpresas";
	}

}
