package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.PessoaFisicaReferencia;

@WebServlet("/alteraCliente")
public class AlteraClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AlteraClienteServlet() {
        super();
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        ClienteDao clienteDao = new ClienteDao();
        PessoaFisicaReferencia cliente = clienteDao.getClientById(codigo);
        
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("pages/editarCliente.jsp").forward(request, response);

	}

}
