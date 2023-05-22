package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDao;
import model.PessoaJuridicaReferencia;

@WebServlet("/atualizaEmpresa")
public class AtualizaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String razaoSocial = request.getParameter("razaoSocial");
        String saldo = request.getParameter("saldo");
        String cnpj = request.getParameter("cnpj");
        
        PessoaJuridicaReferencia empresa = new PessoaJuridicaReferencia(codigo, razaoSocial, saldo, cnpj);
        
        EmpresaDao empresaDao = new EmpresaDao();
        empresaDao.updateEmpresa(empresa);
        
        response.sendRedirect(request.getContextPath() + "/pages/relatorioClienteEmpresa.jsp");
    }
}
