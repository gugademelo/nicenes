package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrinho;
import model.Usuario;
import model.Venda;
import util.Mensagem;

/**
 * Servlet implementation class FecharCompra
 */
@WebServlet("/fechar-compra")
public class FecharCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FecharCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address, frete;
		int id_usuario;
		double valor_frete;
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		if(usuario != null) {
			Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
			id_usuario = usuario.getId();
			valor_frete = 0;
			if(carrinho != null) {
				frete = request.getParameter("frete");
				Venda venda = new Venda(id_usuario, frete, valor_frete);
				if(venda.salva()) {
					address = "/WEB-INF/jsp/pages/sucesso.jsp";
					Mensagem mensagem = new Mensagem("Venda cadastrada com sucesso");
					
					request.setAttribute("mensagem", mensagem);
					RequestDispatcher dispatcher = request.getRequestDispatcher(address);
					dispatcher.forward(request, response);
				}
				else{
					System.out.println("\n\n\n\n erro 1 \n\n\n\n");
				}
			}
			else {
				System.out.println("\n\n\n\n erro 2 \n\n\n\n");
			}
		}
		else {
			System.out.println("\n\n\n\n erro 3 \n\n\n\n");
		}
	}

}
