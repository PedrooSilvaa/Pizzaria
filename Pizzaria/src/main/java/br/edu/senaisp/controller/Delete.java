package br.edu.senaisp.controller;

import java.io.IOException;

import br.edu.senaisp.dao.SaborDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delete")
public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int numDelete = Integer.parseInt(req.getParameter("numero"));
		
		SaborDao dao = new SaborDao();
		
		dao.Delete(numDelete);
		
		resp.sendRedirect("/Pizzaria/lista");
	}
}