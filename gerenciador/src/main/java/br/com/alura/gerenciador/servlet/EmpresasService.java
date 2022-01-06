package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Empresa> listaEmpresas = new Banco().getListaEmpresas();

		String conteudo = request.getHeader("Accept");

		if (conteudo.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String lista = xstream.toXML(listaEmpresas);
			response.setContentType("application/json");
			response.getWriter().print(lista);
		} else if (conteudo.endsWith("json")) {
			Gson gson = new Gson();
			String lista = gson.toJson(listaEmpresas);
			response.setContentType("application/json");
			response.getWriter().print(lista);
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
	}

}
