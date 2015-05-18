package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrinho;
import model.Livro;

/**
 * Servlet implementation class RemoveCarrinho
 */
@WebServlet("/remove-carrinho")
public class RemoveCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
		
		Livro livro = Livro.getLivroPeloId(Integer.parseInt(request.getParameter("id")));
		carrinho.remove(livro);
		
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
