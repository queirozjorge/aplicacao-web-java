package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi", loadOnStartup=1)
public class OiMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OiMundoServlet() {
		System.out.println("Novo objeto servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Primeiro Servlet!");
		out.println("<h3>Primeiro Servlet!</h3>");
		out.println("<h2>Primeiro Servlet!</h2>");
		out.println("<h1>Primeiro Servlet!</h1>");
		out.println("</html>");
		out.println("</body>");
	}
}
