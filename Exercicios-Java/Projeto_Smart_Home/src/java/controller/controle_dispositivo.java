/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.DispositivoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dispositivo;

/**
 *
 * @author User
 */
@WebServlet(name = "controle_dispositivo", urlPatterns = {"/controle_dispositivo"})
public class controle_dispositivo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); 
        
        try (PrintWriter out = response.getWriter()) {
            
            String op = request.getParameter("op");
            DispositivoDAO dao = new DispositivoDAO();
            Dispositivo d = new Dispositivo();

            if (op != null && op.equals("CADASTRAR")) {
                d.setNome(request.getParameter("txtNome"));
                d.setComodo(request.getParameter("txtComodo"));
                d.setMarca(request.getParameter("txtMarca"));
                d.setPotencia(Double.parseDouble(request.getParameter("txtPotencia")));
                d.setHorasUso(Double.parseDouble(request.getParameter("txtHorasUso")));
                d.setVoltagem(Integer.parseInt(request.getParameter("txtVoltagem")));
                d.setStatus(request.getParameter("txtStatus"));
                d.setObservacao(request.getParameter("txtObservacao"));

                double consumo = (d.getPotencia() * d.getHorasUso() * 30) / 1000.0;
                d.setConsumoMensal(consumo);

                try {
                    dao.cadastrar(d);
                    request.setAttribute("message", "Dispositivo cadastrado com sucesso!");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    request.setAttribute("message", "Erro: " + ex.getMessage());
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            } else if (op != null && op.equals("DELETAR")) {
                d.setId(Integer.parseInt(request.getParameter("txtId")));
                
                try {
                    dao.deletar(d);
                    List<Dispositivo> lista = dao.consultarTodos();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    request.setAttribute("message", "Erro: " + ex.getMessage());
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            } else if (op != null && op.equals("CONSULTAR TODOS")) {
                try {
                    List<Dispositivo> lista = dao.consultarTodos();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    request.setAttribute("message", "Erro: " + ex.getMessage());
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            } else if (op != null && op.equals("ATUALIZAR")) {
                d.setId(Integer.parseInt(request.getParameter("txtId")));
                
                try {
                    d = dao.consultarById(d);
                    request.setAttribute("d", d);
                    request.getRequestDispatcher("resultadoconsultaratualizar.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    request.setAttribute("message", "Erro: " + ex.getMessage());
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }

            } else if (op != null && op.equals("EFETIVAR ATUALIZACAO")) {
                d.setId(Integer.parseInt(request.getParameter("txtId")));
                d.setNome(request.getParameter("txtNome"));
                d.setComodo(request.getParameter("txtComodo"));
                d.setMarca(request.getParameter("txtMarca"));
                d.setPotencia(Double.parseDouble(request.getParameter("txtPotencia")));
                d.setHorasUso(Double.parseDouble(request.getParameter("txtHorasUso")));
                d.setVoltagem(Integer.parseInt(request.getParameter("txtVoltagem")));
                d.setStatus(request.getParameter("txtStatus"));
                d.setObservacao(request.getParameter("txtObservacao"));

                double consumo = (d.getPotencia() * d.getHorasUso() * 30) / 1000.0;
                d.setConsumoMensal(consumo);

                try {
                    dao.atualizar(d);
                    request.setAttribute("message", "Dispositivo atualizado com sucesso!");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    request.setAttribute("message", "Erro: " + ex.getMessage());
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
