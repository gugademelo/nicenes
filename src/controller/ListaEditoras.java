package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.Editora;
import util.Mensagem;

/**
 * Servlet implementation class ListaEditoras
 */
@WebServlet("/lista-editoras")
public class ListaEditoras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaEditoras() {
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
			List<Editora> editoras = Editora.lista();
			//request.setAttribute("editoras", editoras);
			
			address = "/WEB-INF/jsp/pages/lista-editoras.jsp";
			request.getSession().setAttribute("editoras", editoras);
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
