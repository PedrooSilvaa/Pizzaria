package br.edu.senaisp.controller;

import java.io.IOException;

import br.edu.senaisp.dao.SaborDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/update")
public class Update extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nomeVar");
		String conteudo = req.getParameter("conteudo");
		int numero = Integer.parseInt(req.getParameter("numero"));
		
		SaborDao dao = new SaborDao();
		
		dao.Update(nome, conteudo, numero);
		
		resp.sendRedirect("/Pizzaria/lista");

	}
}