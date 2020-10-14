/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloPersonal.Personal;

/**
 *
 * @author Usuario
 */
public class sr_per extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Personal personal;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Personal</title>");            
            out.println("</head>");
            out.println("<body>");
            personal = new Personal(Integer.valueOf(request.getParameter("drop_puesto")),Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_nombre_personal"),request.getParameter("txt_apellido_personal"),request.getParameter("txt_telefono_personal"),request.getParameter("txt_direccion_personal"));
            // Boton agregar 
            if ("agregar1".equals(request.getParameter("btn_agregar1"))){
             if (personal.agregar1()>0){
             response.sendRedirect("index_1.jsp");
             
             }else{
             out.println("<h1> xxxxxxx No se Ingreso xxxxxxxxxxxx </h1>");
             out.println("<a href='index_1.jsp'>Regresar...</a>");
             }
             }
            
            // Boton modificar 
            if ("modificar1".equals(request.getParameter("btn_modificar1"))){
             if (personal.modificar1()>0){
             response.sendRedirect("index_1.jsp");
             
             }else{
             out.println("<h1> xxxxxxx No se Modifico xxxxxxxxxxxx </h1>");
             out.println("<a href='index_1.jsp'>Regresar...</a>");
             }
             }
            
            // Boton eliminar 
            if ("eliminar1".equals(request.getParameter("btn_eliminar1"))){
             if (personal.eliminar1()>0){
             response.sendRedirect("index_1.jsp");
             
             }else{
             out.println("<h1> xxxxxxx No se Elimino xxxxxxxxxxxx </h1>");
             out.println("<a href='index_1.jsp'>Regresar...</a>");
             }
             }
            
            
            out.println("</body>");
            out.println("</html>");
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
