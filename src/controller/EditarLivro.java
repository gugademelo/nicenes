package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Mensagem;
import model.Autor;
import model.Categoria;
import model.Editora;
import model.Livro;

/**
 * Servlet implementation class EditarLivro
 */
@WebServlet("/editar-livro")
public class EditarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarLivro() {
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
		}

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = "/WEB-INF/jsp/pages/sucesso.jsp";
		
		Livro livro =
		Livro.getLivroPeloId(Integer.parseInt(request.getParameter("editar_id")));
		

					
		if(livro != null){
			
			
			try{
				
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
				

			if(livro.atualizar()) {
				Mensagem mensagem = new Mensagem("Livro Editado.");
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("usuario", livro);
				address = "/WEB-INF/jsp/pages/sucesso.jsp";
			}
			else {
				Mensagem mensagem = new Mensagem("Nao foi possivel alterar.");
				request.setAttribute("erro", mensagem);
				address = "/WEB-INF/jsp/pages/erro.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
			
			
		}else {
			
			Mensagem mensagem = new Mensagem("Nao foi possivel alterar.");
			request.setAttribute("erro", mensagem);
			address = "/WEB-INF/jsp/pages/erro.jsp";
			
		}

	

	}

}
