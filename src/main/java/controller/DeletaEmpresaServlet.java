package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDao;

@WebServlet("/deletaEmpresa")
public class DeletaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int codigo = Integer.parseInt(request.getParameter("codigo"));

        EmpresaDao empresaDao = new EmpresaDao();
        empresaDao.deleteEmpresa(codigo);

        boolean exclusaoRealizada = empresaDao.deleteEmpresa(codigo);

                if (exclusaoRealizada == false) {
                    request.setAttribute("mensagem", "Exclusão realizada com sucesso.");
                } else {
                    request.setAttribute("mensagem", "Exclusão não realizada com sucesso.");
                }

                request.getRequestDispatcher("pages/confirmaçãodeletada.jsp").forward(request, response);
            }
    }
