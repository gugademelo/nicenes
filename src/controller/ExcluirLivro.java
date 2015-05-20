package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Autor;
import util.Mensagem;
import model.Livro;
/**
 * Servlet implementation class ExcluirLivro
 */
@WebServlet("/excluir-livro")
public class ExcluirLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = "/WEB-INF/jsp/pages/sucesso.jsp";
		
		Livro livro = null; 
		
		
		livro = Livro.getLivroPeloId(Integer.parseInt(request.getParameter("id")));
				
		
		if(livro != null){
			

			if(livro.exclui()) {
				Mensagem mensagem = new Mensagem("Livro Excluido");
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("usuario", livro);
				address = "/WEB-INF/jsp/pages/sucesso.jsp";
			}
			else {
				Mensagem mensagem = new Mensagem("Nao foi possivel Excluir.");
				request.setAttribute("erro", mensagem);
				address = "/WEB-INF/jsp/pages/erro.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);

		}else {
			Mensagem mensagem = new Mensagem("Nao foi possivel Excluir.");
			request.setAttribute("erro", mensagem);
			address = "/WEB-INF/jsp/pages/erro.jsp";
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
