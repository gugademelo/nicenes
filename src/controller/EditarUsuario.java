package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		request.setAttribute("editar", usuario);
		
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
		String address = "/WEB-INF/jsp/pages/sucessoo.jsp";

		// Usuario usuario =
		// Usuario.getUsuarioPeloId(Integer.parseInt(request.getParameter("id")));

		// request.setAttribute("editar", usuario);

		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
