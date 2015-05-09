package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Erro;
import model.Perfil;
import model.Usuario;

/**
 * Servlet implementation class ListaUsuarios
 */
@WebServlet("/lista-usuarios")
public class ListaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address;		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
			
		if(usuario != null) {
			List<Usuario> usuarios = new Usuario().lista();
			address = "/WEB-INF/jsp/lista-usuarios.jsp";
			request.getSession().setAttribute("usuarios", usuarios);
		}
		else {
			address = "/WEB-INF/Erro.jsp";
			Erro erro = new Erro("Você não tem permissão para acessar esta pagina");
			request.setAttribute("erro", erro);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
