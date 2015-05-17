package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Mensagem;
import model.Categoria;
import model.Editora;

/**
 * Servlet implementation class EditarEditora
 */
@WebServlet("/editar-editora")
public class EditarEditora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarEditora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = "/WEB-INF/jsp/pages/cadastra-editora.jsp";

		Editora editora =
		Editora.getEditoraPeloId(Integer.parseInt(request.getParameter("id")));
				
		if(editora != null) 
			request.setAttribute("editar", editora);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		String address = "/WEB-INF/jsp/pages/sucesso.jsp";
		
		Editora editora = null; 
		
		System.out.println();
		
		editora = Editora.getEditoraPeloId(Integer.parseInt(request.getParameter("editar_id")));
		
		
		
		if(editora != null){
			
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
				Mensagem mensagem = new Mensagem("Editora Editada.");
				request.setAttribute("mensagem", mensagem);
				request.setAttribute("usuario", editora);
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
