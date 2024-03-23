package br.edu.senaisp.controller;

import java.io.IOException;

import br.edu.senaisp.dao.ClienteDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/deleteCliente")
public class DeleteCliente extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	int numDelete = Integer.parseInt(req.getParameter("numero"));
		
		ClienteDao dao = new ClienteDao();
		
		dao.Delete(numDelete);
		
		resp.sendRedirect("/Pizzaria/listaCliente");
	}
}