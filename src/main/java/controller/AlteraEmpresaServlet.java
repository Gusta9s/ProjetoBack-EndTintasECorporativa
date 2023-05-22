package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDao;
import model.PessoaJuridicaReferencia;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AlteraEmpresaServlet() {
        super();
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        EmpresaDao empresaDao = new EmpresaDao();
        PessoaJuridicaReferencia empresa = empresaDao.getEmpresaById(codigo);
        
        request.setAttribute("empresa", empresa);
        request.getRequestDispatcher("pages/editarEmpresa.jsp").forward(request, response);

	}

}
