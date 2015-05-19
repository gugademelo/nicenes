package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import util.Mensagem;
import model.Editora;
import model.Perfil;
import model.Usuario;
import model.Categoria;

/**
 * Servlet implementation class EditarCategoria
 */
@WebServlet("/editar-categoria")
public class EditarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = "/WEB-INF/jsp/pages/cadastra-categoria.jsp";

		Categoria categoria =
		Categoria.getCategoriaPeloId(Integer.parseInt(request.getParameter("id")));
		
		if(categoria != null) 
			request.setAttribute("editar", categoria);
		

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = "/WEB-INF/jsp/pages/sucesso.jsp";
		
		Categoria categoria = null; 
		
		
		
		categoria = Categoria.getCategoriaPeloId(Integer.parseInt(request.getParameter("editar_id")));
		
		
		
		if(categoria != null){
			
			categoria.setCategoria(request.getParameter("categoria"));
			

			if(categoria.atualizar()) {
				Mensagem mensagem = new Mensagem("Categoria Editada.");
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("usuario", categoria);
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
