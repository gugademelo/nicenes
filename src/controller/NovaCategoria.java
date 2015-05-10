package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import util.Mensagem;

/**
 * Servlet implementation class NovaCategoria
 */
@WebServlet("/NovaCategoria")
public class NovaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address;		
		Categoria categoria = new Categoria();
		categoria.setCategoria(request.getParameter("categoria"));
		
		if(categoria.salva()) {
			Mensagem mensagem = new Mensagem("Categoria cadastrada!");
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("categoria", categoria);
			address = "/WEB-INF/jsp/pages/sucesso.jsp";
		}
		else {
			Mensagem mensagem = new Mensagem("Nao foi possivel cadastrar.");
			request.setAttribute("mensagem", mensagem);
			address = "/WEB-INF/jsp/pages/erro.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
