package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Editora;
import model.Usuario;
import util.Mensagem;
import model.Categoria;

/**
 * Servlet implementation class ListaCategorias
 */
@WebServlet("/lista-categorias")
public class ListaCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address;		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		

			
		if(usuario != null) {
			List<Categoria> categorias = Categoria.lista();
			//request.setAttribute("editoras", editoras);
			
			address = "/WEB-INF/jsp/pages/lista-categorias.jsp";
			request.getSession().setAttribute("categorias", categorias);
		}
		else {
			address = "/WEB-INF/jsp/pages/erro.jsp";
			Mensagem mensagem = new Mensagem("Voc� n�o tem permiss�o para acessar esta pagina");
			request.setAttribute("erro", mensagem);
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
