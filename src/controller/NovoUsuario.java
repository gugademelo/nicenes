package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Erro;
import model.Perfil;
import model.Usuario;

/**
 * Servlet implementation class CadastraUsuario
 */
@WebServlet("/novo-usuario")
public class NovoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NovoUsuario() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address;		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		address = "/cadastra-usuario.jsp";
		
		if(usuario != null) {
			List<Perfil> perfis = new Perfil().lista();
			request.setAttribute("perfis", perfis);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address;		
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			usuario.setPerfil(Integer.parseInt(request.getParameter("perfil")));
		}
		else {
			usuario.setPerfil(2);
		}
		
		if(usuario.salva()) {
			request.setAttribute("usuario", usuario);
			address = "/WEB-INF/UsuarioCadastrado.jsp";
		}
		else {
			Erro erro = new Erro("Nao foi possivel logar.");
			request.setAttribute("erro", erro);
			address = "/WEB-INF/Erro.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
