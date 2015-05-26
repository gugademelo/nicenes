package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Autor;
import model.Categoria;
import model.Editora;
import model.Livro;

/**
 * Servlet implementation class VisualizarAutor
 */
@WebServlet("/visualizar-livro")
public class VisualizarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String address = "/WEB-INF/jsp/pages/cadastra-livro.jsp";

		
		
		Livro livro =
		Livro.getLivroPeloId(Integer.parseInt(request.getParameter("id")));
		
		if(livro != null){ 
			request.setAttribute("editar", livro);
			
			List<Categoria> categorias = Categoria.lista();
			request.setAttribute("categorias", categorias);
			
			List<Editora> editoras = Editora.lista();
			request.setAttribute("editoras", editoras);
			
			List<Autor> autores = Autor.lista();
			request.setAttribute("autores", autores);
			
			request.setAttribute("visualizar", 1);
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
