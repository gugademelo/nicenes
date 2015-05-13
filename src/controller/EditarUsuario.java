package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Mensagem;
import model.Perfil;
import model.Usuario;

/**
 * Servlet implementation class EditaUsuario
 */
@WebServlet("/editar-usuario")
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/jsp/pages/cadastra-usuario.jsp";

		Usuario usuario =
		Usuario.getUsuarioPeloId(Integer.parseInt(request.getParameter("id")));
		
		if(usuario != null) request.setAttribute("editar", usuario);
		
		List<Perfil> perfis = new Perfil().lista();
		request.getSession().setAttribute("perfis", perfis);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/jsp/pages/sucesso.jsp";
		
		Usuario usuario = Usuario.getUsuarioPeloId(Integer.parseInt(request.getParameter("editar_id")));
		if(usuario != null) {
			usuario.setNome(request.getParameter("nome"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setPerfil(Perfil.getPerfilPeloId(Integer.parseInt(request.getParameter("perfil"))));
			usuario.salva();
		}

		// Usuario usuario =
		// Usuario.getUsuarioPeloId(Integer.parseInt(request.getParameter("id")));

		// request.setAttribute("editar", usuario);
		Mensagem mensagem = new Mensagem("rola");
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
