package br.edu.senaisp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import br.edu.senaisp.dao.SaborDao;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/updatepart1")
public class UpdateTela extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numero = Integer.parseInt(req.getParameter("numero"));
		
		StringBuilder html = new StringBuilder();
		html.append("");
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset='UTF-8'>");
		html.append("<title>Pagina Principal</title>");
		html.append("<style>");
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
		html.append("    justify-content: space-around;");
		html.append("    background-color: #e28a2e;");
		html.append("    color: white;");
		html.append("    width: 300px;");
		html.append("    height: 250px;");
		html.append("    align-items: center;");
		html.append("    padding: 10px;");
		html.append("    font-size: 20px;");
		html.append("    font-weight: 900;");
		html.append("}");
		html.append("");
		html.append("form select, input {");
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
		html.append(".idMudanca{");
		html.append("	display: none;");
		html.append("}");
		html.append("a{");
		html.append("color: white;");
		html.append("}");
		html.append("</style>");
		html.append("</head>");
		html.append("<body>");
		html.append("<form action='/Pizzaria/update'>");
		html.append("    <label for=\"opcoes\">O que queres mudar?</label>");
		html.append("    <select name=\"nomeVar\" id=\"opcoes\">");
		html.append("        <option value=\"nome\">Nome</option>");
		html.append("<option value='descricao'>Descrição</option>");
		html.append("<option value='preco'>Preço</option>");
		html.append("</select>");
		html.append("<label for='conteudo'>Adicione o conteudo aqui:</label>");
		html.append("<input type='text' name='conteudo'>");
		html.append("<button type='submit'>Alterar</button>");
		html.append("<input class='idMudanca' type='number' name='numero' value=").append(numero).append(">");
		html.append("</form>");
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter pw = resp.getWriter();
		pw.print(html.toString());

	}
}