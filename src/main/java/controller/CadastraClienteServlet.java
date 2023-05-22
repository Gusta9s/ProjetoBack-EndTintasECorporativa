package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.PessoaFisicaReferencia;

@WebServlet("/cadastraCliente")
public class CadastraClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDao clienteDao;

    public CadastraClienteServlet() {
        super();
        clienteDao = new ClienteDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String nome = request.getParameter("nome");
        String saldo = request.getParameter("saldo");
        String cpf = request.getParameter("cpf");

        if (nome != null && !nome.isEmpty() && saldo != null && !saldo.isEmpty() && cpf != null && !cpf.isEmpty()) {
            PessoaFisicaReferencia cliente = new PessoaFisicaReferencia(nome, saldo, cpf);
            clienteDao.insertCliente(cliente);

            String mensagem = "Dados enviados com sucesso!";
            request.setAttribute("mensagem", mensagem);
        } else {
            String mensagem = "Dados incompletos. Tente novamente.";
            request.setAttribute("mensagem", mensagem);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/confirmacao.jsp");
        dispatcher.forward(request, response);
    }
}