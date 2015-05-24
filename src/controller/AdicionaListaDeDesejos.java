package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListaDeDesejos;
import model.Livro;
import model.Usuario;
import util.Mensagem;

/**
 * Servlet implementation class AdicionaListaDeDesejos
 */
@WebServlet("/adiciona-lista-de-desejos")
public class AdicionaListaDeDesejos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaListaDeDesejos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "";
		Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		if(usuarioLogado != null) {
			Livro livro = Livro.getLivroPeloId(Integer.parseInt(request.getParameter("id")));
			if(ListaDeDesejos.adiciona(usuarioLogado, livro)) {
				response.setContentType("text/html");

			    String site = new String("/nicenes");

			    response.setStatus(response.SC_MOVED_TEMPORARILY);
			    response.setHeader("Location", site);
			}
			else {
				address = "WEB-INF/jsp/pages/erro.jsp";
				Mensagem mensagem = new Mensagem("Houve um problema, tente novamente.");
				request.setAttribute("mensagem", mensagem);
			}
		}	
		else {
			address = "WEB-INF/jsp/pages/login.jsp";
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
