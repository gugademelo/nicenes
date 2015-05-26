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
	
			try{
					Livro livro = new Livro();
					livro.setTitulo(request.getParameter("titulo"));
					livro.setIsbn(request.getParameter("isbn"));
					livro.setColecao(request.getParameter("colecao"));
					livro.setEdicao(request.getParameter("edicao"));
					livro.setIdioma(request.getParameter("idioma"));
					livro.setPreco(Double.parseDouble(request.getParameter("preco").replace(",", ".")));
					livro.setAno(Integer.parseInt(request.getParameter("ano")));
					livro.setAutor(Integer.parseInt(request.getParameter("autor")));
					livro.setEditora(Integer.parseInt(request.getParameter("editora")));
					livro.setCategoria(Integer.parseInt(request.getParameter("categoria")));
				
								
	        
		        String address;
		        Mensagem mensagem = new Mensagem();
		        if(livro.salva()) {
		        	address = "/WEB-INF/jsp/pages/sucesso.jsp";
		        	mensagem.setTexto("Livro cadastrado com sucesso.");
		        }
		        else{
		        	address = "/WEB-INF/jsp/pages/erro.jsp";
		        	mensagem.setTexto("Livro cadastrado com sucesso.");
		        }
		        request.setAttribute("mensagem", mensagem);
		        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		        dispatcher.forward(request, response);
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				String linkerro = "/WEB-INF/jsp/pages/erro.jsp";
				Mensagem msg = new Mensagem(); 
				msg.setTexto("Campos Preço ou Ano incorretos.");
				request.setAttribute("mensagem", msg);
				e.printStackTrace();
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(linkerro);
				dispatcher.forward(request, response);
			}  

	}

}
