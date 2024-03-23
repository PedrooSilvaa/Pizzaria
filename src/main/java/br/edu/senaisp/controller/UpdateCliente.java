package br.edu.senaisp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import br.edu.senaisp.dao.ClienteDao;
import br.edu.senaisp.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/updateCliente")
public class UpdateCliente extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	int id = Integer.parseInt(req.getParameter("id"));
		
		ClienteDao dao = new ClienteDao();
		Cliente c = dao.buscaPorId(id);
		
		StringBuffer html = new StringBuffer();
		html.append("<!DOCTYPE html>");
		html.append("<html lang=\"pt-br\">");
		html.append("<head>");
		html.append("<meta charset='UTF-8'>");
		html.append("<title>Pagina Principal</title>");
		html.append("<style>");
		html.append("* {");
		html.append("    padding: 0;");
		html.append("}");
		html.append("body {");
		html.append("    background-color: #064c53;");
		html.append("    display: flex;");
		html.append("    flex-direction: column;");
		html.append("    align-items: center;");
		html.append("    justify-content: center;");
		html.append("    height: 100vh;");
		html.append("}");
		html.append("");
		html.append("form {");
		html.append("    border: 2px white solid;");
		html.append("    display: flex;");
		html.append("    flex-direction: column;");
		html.append("    justify-content: center;");
		html.append("    background-color: #e28a2e;");
		html.append("    color: white;");
		html.append("    width: 300px;");
		html.append("    height: fit-content;");
		html.append("    align-items: center;");
		html.append("    font-weight: 900;");
		html.append("}");
		html.append("");
		html.append("form input {");
		html.append("    height: 30px;");
		html.append("    width: 150px;");
		html.append("    background-color: #fff;");
		html.append("    border-bottom: 1px solid black;");
		html.append("}");
		html.append("");
		html.append("form button {");
		html.append("    height: 30px;");
		html.append("    width: 50%;");
		html.append("    font-weight: 900;");
		html.append("    cursor: pointer;");
		html.append("    background-color: #cd1c25;");
		html.append("    color: white;");
		html.append("    border: solid white ;");
		html.append("}");
		html.append("a{");
		html.append("color: white;");
		html.append("}");
		html.append("</style>");
		html.append("</head>");
		html.append("<body>");
		html.append("	<form action='/Pizzaria/updateCliente' method='POST'>");
		html.append("		<input type='hidden' name='id' value='"+c.getId()+"' /> <br><br>");		
		html.append("		<label for='nome'>Nome:</label> ");
		html.append("		<input type='text' name='nome' value='"+c.getNome()+"' /> <br><br>");
		html.append("		<label for='telefone'>Telefone:</label> ");
		html.append("		<input type='text' name='telefone' value='"+c.getTelefone()+"' /><br><br> ");
		html.append("		<label for='rua'>Rua:</label> ");
		html.append("		<input type='text' name='rua' value='"+c.getRua()+"' /><br><br>");
		html.append("		<label for='nr'>Numero:</label> ");
		html.append("		<input type='number' name='nr' value='"+c.getNr()+"' /><br><br>");
		html.append("		<label for='bairro'>Bairro:</label> ");
		html.append("		<input type='text' name='bairro' value='"+c.getBairro()+"' /><br><br>");
		html.append("		<button type='submit'>Gravar</button>");
		html.append("	</form>");
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter pw = resp.getWriter();
		pw.print(html.toString());		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		String rua = req.getParameter("rua");
		int nr = Integer.parseInt(req.getParameter("nr"));
		String bairro = req.getParameter("bairro");
		int id = Integer.parseInt(req.getParameter("id"));
		
		Cliente c = new Cliente();
		
		c.setId(id);
		c.setNome(nome);
		c.setTelefone(telefone);
		c.setRua(rua);
		c.setNr(nr);
		c.setBairro(bairro);

		ClienteDao dao = new ClienteDao();
		dao.Update(c);
		
		resp.sendRedirect("/Pizzaria/listaCliente");
	}
}