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
import model.Autor;

/**
 * Servlet implementation class ExcluirAutor
 */
@WebServlet("/excluir-autor")
public class ExcluirAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirAutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = "/WEB-INF/jsp/pages/sucesso.jsp";
		
		Autor autor = null; 
		
		
		autor = Autor.getAutorPeloId(Integer.parseInt(request.getParameter("id")));
				
		
		if(autor != null){
			

			if(autor.exclui()) {
				Mensagem mensagem = new Mensagem("Usuario Excluido");
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("usuario", autor);
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
