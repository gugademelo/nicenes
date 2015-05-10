package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Editora;
import util.Mensagem;

/**
 * Servlet implementation class NovaEditora
 */
@WebServlet("/NovaEditora")
public class NovaEditora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaEditora() {
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
		// TODO Auto-generated method stub
		String address;		
		Editora editora = new Editora();
		editora.setNome(request.getParameter("nome"));
		editora.setEndereco(request.getParameter("endereco"));
		editora.setCidade(request.getParameter("cidade"));
		editora.setUf(request.getParameter("uf"));
		editora.setPais(request.getParameter("pais"));
		editora.setCep(Integer.parseInt(request.getParameter("cep")));
		editora.setFone(Integer.parseInt(request.getParameter("fone")));
		editora.setCnpj(Integer.parseInt(request.getParameter("cnpj")));
		editora.setRazaoSocial(request.getParameter("razao"));
		editora.setWeb(request.getParameter("web"));
		
		if(editora.salva()) {
			Mensagem mensagem = new Mensagem("Editora cadastrada.");
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("editora", editora);
			address = "/WEB-INF/jsp/pages/Sucesso.jsp";
		}
		else {
			Mensagem mensagem = new Mensagem("Nao foi possivel cadastrar.");
			request.setAttribute("mensagem", mensagem);
			address = "/WEB-INF/jsp/pages/Erro.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	

}
