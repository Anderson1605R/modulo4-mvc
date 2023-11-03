package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.UserModel;

/**
 * Servlet implementation class UserControllerCreate
 */
@WebServlet("/cadastro")
public class UserControllerCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UserModel user = new UserModel();
		user.setNome(nome);
		user.setCpf(cpf);
		user.setEmail(email);
		user.setSenha(senha);
		
		try {
			UserDAO.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		response.sendRedirect("/rochaTour/");
		
		
		
	}

}
