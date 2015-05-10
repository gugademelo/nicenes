package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import util.Mensagem;

/**
 * Servlet implementation class ExcluirUsuario
 */
@WebServlet("/excluir-usuario")
public class ExcluirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/nicenes/lista-usuarios";
		
		Usuario usuario = Usuario.getUsuarioPeloId(Integer.parseInt(request.getParameter("id")));
		
		if(!usuario.exclui() || usuario == null) {
			address = "/WEB-INF/jsp/pages/erro.jsp";
			Mensagem mensagem = new Mensagem();
			mensagem.setTexto("Nao foi possive excluir o usuario");
			
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
	    response.setContentType("text/html");
	    response.setStatus(response.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", address);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
