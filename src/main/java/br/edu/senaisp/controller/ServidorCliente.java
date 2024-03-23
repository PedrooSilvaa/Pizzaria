package br.edu.senaisp.controller;

import java.io.IOException;

import br.edu.senaisp.dao.ClienteDao;
import br.edu.senaisp.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servidorCliente")
public class ServidorCliente extends HttpServlet {

	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome"); //getParameter usado para pegar o parametro passado e guardar na variavel
		String telefone = req.getParameter("telefone");
		String rua = req.getParameter("rua");
		int nr = Integer.parseInt(req.getParameter("nr"));
		String bairro = req.getParameter("bairro");
				
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setTelefone(telefone);
		c.setRua(rua);
		c.setNr(nr);
		c.setBairro(bairro);
		
		ClienteDao dao = new ClienteDao();
		dao.novo(c);
		resp.sendRedirect("/Pizzaria/listaCliente");
		
	}
}