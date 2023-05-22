package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.EmpresaDao;
import model.PessoaJuridicaReferencia;

@WebServlet("/listaEmpresa")
public class ListaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmpresaDao empresaDao;

    public ListaEmpresaServlet() {
        super();
        empresaDao = new EmpresaDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PessoaJuridicaReferencia> empresas = empresaDao.getAllEmpresas();
        request.setAttribute("empresas", empresas);
        request.getRequestDispatcher("pages/relatorioClienteEmpresa.jsp").forward(request, response);
    }
}