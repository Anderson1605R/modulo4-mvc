package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.UserModel;


@WebServlet("/atualizar")
public class UserControllerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserModel user = UserDAO.findById(id);
		
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("atualizar.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		int id = Integer.parseInt(request.getParameter("id"));
		UserModel user = UserDAO.findById(id);
		user.setNome(nome);
		user.setCpf(cpf);
		user.setEmail(email);
		user.setSenha(senha);
		
		
		try {
			UserDAO.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		response.sendRedirect("/rochaTour/");
		
	}

}
