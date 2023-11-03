package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.UserModel;

@WebServlet("/")
public class UserControllerList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			pega todos os usuários do bd
			List<UserModel> clientes = UserDAO.getUsers();
			
//			salva os clientes em uma variavel cliente que pode ser enviada para usar na jsp
			request.setAttribute("clientes", clientes);
			
//			endereça o request para uma jsp especifica
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			
//			envia resposta e requisição para o front jsp 
			rd.forward(request, response);
			
			response.sendRedirect("/rochaTour/");
		} catch (Exception e) {
			e.printStackTrace();;
		}
		
		
		
	}

	




	

}
