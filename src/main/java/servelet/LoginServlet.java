/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author f1000
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simulación de base de datos de usuarios
        String dbUsername = "admin";
        String dbPassword = "admin";

        if (username.equals(dbUsername) && password.equals(dbPassword)) {
            // Usuario autenticado correctamente, redireccionar a la página de inicio
            response.sendRedirect("redirect.jsp");
        } else {
            // Usuario no autenticado, mostrar mensaje de error
            request.setAttribute("errorMessage", "Credenciales incorrectas");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}
