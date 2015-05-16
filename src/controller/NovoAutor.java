package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Mensagem;
import model.Autor;
import model.Categoria;
import model.Editora;

/**
 * Servlet implementation class NovoAutor
 */
@WebServlet("/novo-autor")
public class NovoAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovoAutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/jsp/pages/cadastra-autor.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        java.util.Date parsed;
		try {
			Autor autor = new Autor();
			autor.setNome(request.getParameter("nome"));
			autor.setSobrenome(request.getParameter("sobrenome"));
			autor.setPrincipalLivro(request.getParameter("principal_livro"));
			autor.setEndereco(request.getParameter("endereco"));
			autor.setTelefone(request.getParameter("telefone"));
			autor.setEmail(request.getParameter("email"));
			autor.setRg(request.getParameter("rg"));
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			parsed = format.parse(request.getParameter("data_nascimento"));
	        autor.setDtNascimento(parsed);
	        
	        autor.setObs(request.getParameter("obs"));
	        autor.setQtdLivros(Integer.parseInt(request.getParameter("qtd_livros")));
	        
	        String address;
	        Mensagem mensagem = new Mensagem();
	        if(autor.salva()) {
	        	address = "/WEB-INF/jsp/pages/sucesso.jsp";
	        	mensagem.setTexto("Autor cadastrado com sucesso.");
	        }
	        else{
	        	address = "/WEB-INF/jsp/pages/erro.jsp";
	        	mensagem.setTexto("Autor cadastrado com sucesso.");
	        }
	        request.setAttribute("mensagem", mensagem);
	        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	        dispatcher.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		
	}

}
