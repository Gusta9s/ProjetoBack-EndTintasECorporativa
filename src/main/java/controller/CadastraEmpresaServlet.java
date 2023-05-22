package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDao;
import model.PessoaJuridicaReferencia;

@WebServlet("/cadastraEmpresa")
public class CadastraEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmpresaDao EmpresaDao;

    public CadastraEmpresaServlet() {
    	super();
    	EmpresaDao = new EmpresaDao();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String razaoSocial = request.getParameter("razaosocial");
        String saldo = request.getParameter("saldo");
        String cnpj = request.getParameter("cnpj");

        if (razaoSocial != null && !razaoSocial.isEmpty() && saldo != null && !saldo.isEmpty() && cnpj != null && !cnpj.isEmpty()) {
            PessoaJuridicaReferencia empresa = new PessoaJuridicaReferencia(razaoSocial, saldo, cnpj);
            EmpresaDao.insertEmpresa(empresa);

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