package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		Empresa empresa2 = new Empresa();
		empresa.setNome("Alura");
		empresa2.setNome("Caelum");
		empresa.setCnpj("11.111.111/1111-11");
		empresa2.setCnpj("22.222.222/2222-22");
		empresa.setId(chaveSequencial++);
		empresa2.setId(chaveSequencial++);
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("convidado");
		u1.setSenha("123");
		Usuario u2 = new Usuario();
		u2.setLogin("usuario");
		u2.setSenha("321");
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		listaEmpresas.add(empresa);
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void removerEmpresa(Integer idParametro) {

		Empresa emp = null;
		for (Empresa empresa : listaEmpresas) {
			if (empresa.getId() == idParametro) {
				emp = empresa;
			}
		}
		listaEmpresas.remove(emp);
	}

	public Empresa buscarEmpresaPorId(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if (empresa.getId().equals(id)) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.confirmarLoginESenha(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
