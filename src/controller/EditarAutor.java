package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.ParserException;
import util.Mensagem;
import model.Categoria;
import model.Autor;

/**
 * Servlet implementation class EditarAutor
 */
@WebServlet("/editar-autor")
public class EditarAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarAutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = "/WEB-INF/jsp/pages/cadastra-autor.jsp";

		Autor autor =
		Autor.getAutorPeloId(Integer.parseInt(request.getParameter("id")));
		
		if(autor != null) 
			request.setAttribute("editar", autor);
		

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/jsp/pages/sucesso.jsp";
		
		Autor autor = null; 
		
		autor = Autor.getAutorPeloId(Integer.parseInt(request.getParameter("editar_id")));

		
		if(autor != null){
			
			
			
			autor.setNome(request.getParameter("nome"));
			autor.setSobrenome(request.getParameter("sobrenome"));
			autor.setPrincipalLivro(request.getParameter("principal_livro"));
			autor.setEndereco(request.getParameter("endereco"));
			autor.setTelefone(request.getParameter("telefone"));
			autor.setEmail(request.getParameter("email"));
			autor.setRg(request.getParameter("rg"));
			
			java.util.Date parsed;
			try{
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			
	
				parsed = format.parse(request.getParameter("data_nascimento"));
				autor.setDtNascimento(parsed);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        autor.setObs(request.getParameter("obs"));
	        autor.setQtdLivros(Integer.parseInt(request.getParameter("qtd_livros")));

			

			if(autor.atualizar()) {
				Mensagem mensagem = new Mensagem("Autor Editado.");
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("usuario", autor);
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
