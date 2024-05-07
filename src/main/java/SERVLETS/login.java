/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SERVLETS;

import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author f1000
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession sesion = request.getSession();
            
            MetodosSQL metodos = new MetodosSQL();
            String txtNombres = request.getParameter("txtnom");
            String txtCorreo = request.getParameter("txtCorreo");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            
            boolean iniciarSesion = metodos.buscarUsuarioInicioSesion(txtNombres, txtCorreo);
            if(iniciarSesion == true){ //EL usuario puede accesar por que esta registrado
                out.println("alert('¡Bienvenido a mi pagina! \\nIniciaste sesion como: "+txtNombres+"')");
                out.println("location = 'principal.jsp'");
                
                String nombre = metodos.buscarNombre(txtNombres);
                //System.out.println("El valor del nombre en el SERVLET es: " + nombre);
                
                sesion.setAttribute("txtnom", nombre);
                sesion.setAttribute("txtCorreo", txtNombres);
            }else{
                out.println("alert('Datos Incorrectos, verifica tus credenciales o date de alta en el sistema')");
                out.println("location = 'index.jsp'");
            }
            System.out.println("El valor de inciasSesion dentro del SERVLET es: " + iniciarSesion);
            
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        
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
