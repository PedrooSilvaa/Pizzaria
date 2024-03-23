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

@WebServlet(urlPatterns = "/listaCliente")
public class ListaCliente extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		StringBuilder html = new StringBuilder();
		html.append("");
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset='ISO-8859-1'>");
		html.append("<title>Pagina Principal</title>");
		html.append("<style>");
		html.append("body {");
		html.append("    background-color: #064c53;");
		html.append("}");
		html.append("");
		html.append(".grid {");
		html.append("    display: grid;");
		html.append("    grid-template-columns: 1fr;");
		html.append("    place-items: center;");
		html.append("}");
		html.append("");
		html.append(".box :nth-child(n) {");
		html.append("    width: 20%;");
		html.append("}");
		html.append(".box {");
		html.append("    border: 2px white solid;");
		html.append("    display: flex;");
		html.append("    justify-content: space-around;");
		html.append("    width: 90%;");
		html.append("    background-color: #e28a2e;");
		html.append("    color: white;");
		html.append("    align-items: center;");
		html.append("    padding: 10px;");
		html.append("}");
		html.append("");
		html.append("button {");
		html.append("    height: 30px;");
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
		html.append("<div class='grid'>");
		html.append("<button onclick=\"window.location.href = '/Pizzaria/cadastro.html'\">NOVO</button>");
		html.append("<button onclick=\"window.location.href = '/Pizzaria/cadastroCliente.html'\">NOVO CLIENTE</button>");
		
		ClienteDao dao = new ClienteDao();
		for (Cliente cliente : dao.lista()) {
			
			html.append("<div class='box'>");
			html.append("<h2>").append(cliente.getNome()).append("</h2>");
			html.append("<h2>").append(cliente.getTelefone()).append("</h2>");
			html.append("<h2>").append(cliente.getRua()).append("</h2>");
			html.append("<h2>").append(cliente.getNr()).append("</h2>");
			html.append("<h2>").append(cliente.getBairro()).append("</h2>");
			html.append("<button onclick=\"window.location.href='/Pizzaria/deleteCliente?numero=").append(cliente.getId()).append("'\">Deletar</button>");
			html.append("<button onclick=\"window.location.href='/Pizzaria/updateCliente?id=").append(cliente.getId()).append("'\">Editar</button>");
			html.append("</div>");
		}
		
		html.append("</div>");
			
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter pw = response.getWriter();
		pw.print(html.toString());
		
		
	}
}