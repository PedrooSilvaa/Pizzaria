package br.edu.senaisp.controller;

import java.io.IOException;

import br.edu.senaisp.dao.SaborDao;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servidor") //dando nome ao servidor, será usado na url de pesquisa

public class Servidor extends HttpServlet{ //extends de http servlet para poder usar o servidor

	@Override // service usado para requirir os parametros e da resposta
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome"); //getParameter usado para pegar o parametro passado e guardar na variavel
		String descricao = req.getParameter("descricao");
		float preco = Float.parseFloat(req.getParameter("preco"));
				
		Sabor s = new Sabor();
		s.setNome(nome);
		s.setDescricao(descricao);
		s.setPreco(preco);
 
		SaborDao dao = new SaborDao();
		dao.novo(s);
		resp.sendRedirect("/Pizzaria/lista");
		
	}
	
}
