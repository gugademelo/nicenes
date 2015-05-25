package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Mensagem;
import model.Categoria;
import model.ItemVenda;
import model.Livro;
import model.Usuario;
import model.Venda;
import model.ItemVenda;
/**
 * Servlet implementation class ListaCompras
 */
@WebServlet("/lista-compras")
public class ListaCompras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCompras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		String address = "/WEB-INF/jsp/pages/lista-compras.jsp";
		
		if(usuario != null) {
			List<Venda> vendas = Venda.lista(usuario);
			
			
			List<ItemVenda> itensGeral = new ArrayList<ItemVenda>();
			
			for(Venda venda: vendas) {
				
				List<ItemVenda> itensVendas = ItemVenda.lista(venda);
				
				for(ItemVenda item : itensVendas){
					itensGeral.add(item);
				}
				
				
			}
			//System.out.println(itensGeral.get(1).getLivro().getTitulo());
			
			request.getSession().setAttribute("vendas", vendas);
			request.getSession().setAttribute("itensvenda", itensGeral);
		
			
		}else {
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
