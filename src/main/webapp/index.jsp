<%-- 
    Document   : index
    Created on : May 6, 2024, 3:35:49 PM
    Author     : f1000
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="SQL.connector" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="login">
            <div class="form-group">
                <label for="username">Username:</label>
                <input id="username" name="txtnom" required>
            </div>
            <div class="form-group">
                <label for="password">Correo:</label>
                <input id="password" name="txtCorreo" required>
            </div>
            <div class="form-group">
                <button type="submit" name="action" value="Ingresar">Login</button>
            </div>
        </form>
    </div>
</body>

</html>
