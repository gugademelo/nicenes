package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrinho;
import model.Livro;
import model.Perfil;
import model.Usuario;

/**
 * Servlet implementation class AdicionaCarrinho
 */
@WebServlet("/adiciona-carrinho")
public class AdicionaCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
		
		if(carrinho == null) {
			carrinho = new Carrinho();
		}
		
		Livro livro = Livro.getLivroPeloId(Integer.parseInt(request.getParameter("id")));
		carrinho.adiciona(livro);
		
		request.getSession().setAttribute("carrinho", carrinho);
		
	    response.setContentType("text/html");

	    String site = new String("/nicenes");

	    response.setStatus(response.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
