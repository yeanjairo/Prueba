<%-- 
    Document   : index2
    Created on : 11/10/2020, 02:26:58 PM
    Author     : Windows 10
--%>

<%@page import="beans.BUsuario"%>
<%@page import="dao.DaoUsuarioImag"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="conteiner mt-4">
            <div class="card-header">
                <div class="card-header">
                    <a class="btn btn-primary">Nuevo Usuario</a>
                </div>

                <div class="card-body">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NOMBRE</th>
                                <th>APELLIDOS</th>   
                                <th>ACCIONES</th>
                            </tr>
                        </thead>

                        <tbody>
                            <%
                                DaoUsuarioImag u = new DaoUsuarioImag();
                                List<BUsuario> lista = u.listar();
                                
                                int t;
                                try {
                                    if (lista.isEmpty()) {
                                        t = 0;
                                    } else {
                                        t = lista.size();
                                    }
                                    int i = 0;
                                    if (t > 0) {
                                        while (i < t) {
                            %>
                            <tr>
                                <td> <%= lista.get(i).getId()  %> </td>
                                <td> <%= lista.get(i).getNombre() %> </td>
                                <td> <%= lista.get(i).getApellidos() %> </td>   
                                <td>
                                    <a href=" " class="btn btn-warning">Edit</a>
                                    <a href=" " class="btn btn-danger">Delete</a>
                                </td>
                            </tr>

                            <%
                                            i = i + 1;
                                        }
                                    }
                                } catch (Exception e) {
                                    throw e;
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
