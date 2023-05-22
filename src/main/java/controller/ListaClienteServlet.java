package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClienteDao;
import model.PessoaFisicaReferencia;

@WebServlet("/listaCliente")
public class ListaClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDao clienteDao;

    public ListaClienteServlet() {
        super();
        clienteDao = new ClienteDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PessoaFisicaReferencia> clientes = clienteDao.getAllClientes();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("pages/relatorioClienteEmpresa.jsp").forward(request, response);
    }
}