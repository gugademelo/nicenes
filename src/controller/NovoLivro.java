package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Mensagem;
import model.Categoria;
import model.Editora;
import model.Autor;
import model.Livro;

/**
 * Servlet implementation class NovoLivro
 */
@WebServlet("/novo-livro")
public class NovoLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovoLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/jsp/pages/cadastra-livro.jsp";
		
		List<Categoria> categorias = Categoria.lista();
		request.setAttribute("categorias", categorias);
		
		List<Editora> editoras = Editora.lista();
		request.setAttribute("editoras", editoras);
		
		List<Autor> autores = Autor.lista();
		request.setAttribute("autores", autores);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			Livro livro = new Livro();
			livro.setLivro_id(Integer.parseInt(request.getParameter("sobrenome")));
			livro.setTitulo(request.getParameter("sobrenome"));
			livro.setIsbn(request.getParameter("sobrenome"));
			livro.setColecao(request.getParameter("sobrenome"));
			livro.setEdicao(request.getParameter("sobrenome"));
			livro.setIdioma(request.getParameter("sobrenome"));
			livro.setAssunto(request.getParameter("sobrenome"));
			livro.setAno(Integer.parseInt(request.getParameter("sobrenome")));
			livro.setAutor(request.getParameter("autor"));
			livro.setEditora(request.getParameter("editora"));
			livro.setCategoria(request.getParameter("categoria"));
						
	        
	        String address;
	        Mensagem mensagem = new Mensagem();
	        if(livro.salva()) {
	        	address = "/WEB-INF/jsp/pages/sucesso.jsp";
	        	mensagem.setTexto("Autor cadastrado com sucesso.");
	        }
	        else{
	        	address = "/WEB-INF/jsp/pages/erro.jsp";
	        	mensagem.setTexto("Autor cadastrado com sucesso.");
	        }
	        request.setAttribute("mensagem", mensagem);
	        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	        dispatcher.forward(request, response);
		

	}

}
