package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.UserModel;


@WebServlet("/deletar")
public class UserControllerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			UserModel user = new UserModel();
			user.setId(id);
			
			UserDAO.remove(user.getId());
			response.sendRedirect("/rochaTour/");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
