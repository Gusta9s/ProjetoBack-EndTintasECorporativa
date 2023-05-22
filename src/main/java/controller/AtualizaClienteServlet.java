package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.PessoaFisicaReferencia;

@WebServlet("/atualizaCliente")
public class AtualizaClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String saldo = request.getParameter("saldo");
        String cpf = request.getParameter("cpf");
        
        PessoaFisicaReferencia cliente = new PessoaFisicaReferencia(codigo, nome, saldo, cpf);
        
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.updateCliente(cliente);
        
        response.sendRedirect(request.getContextPath() + "/pages/relatorioClienteEmpresa.jsp");
    }
}