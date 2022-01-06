package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Removendo empresa");
		Integer idParametro = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		banco.removerEmpresa(idParametro);
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
