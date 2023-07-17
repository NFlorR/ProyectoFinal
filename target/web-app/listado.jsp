<%@ page import="java.util.ArrayList" %>
<%@ page import="ar.com.codoacodo23049.Articulo" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CAC - 23049</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container">
      <div class="row">
        <div class="col-12">
            <% String ok = (String)request.getAttribute("eliminadook");%>
            <% String fail = (String)request.getAttribute("eliminadofail");%>

            <%
            if(ok != null) {
            %>
                <div class="alert alert-success">
                    exito
                </div>
            <%
            }
            %>
            <%
            if(fail != null) {
            %>
                <div class="alert alert-danger">
                    error
                </div>
            <%
            }
            %>
            <table class="table">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">TITULO</th>
                    <th scope="col">PRECIO</th>
                    <th scope="col">IMAGEN</th>
                    <th scope="col">AUTOR</th>
                    <th scope="col">CODIGO</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                    <% 
                    ArrayList<Articulo> listado = (ArrayList<Articulo>)request.getAttribute("listado");//[]
                        for(Articulo unarticulo : listado) {
                    %>
                        <tr>
                            <th scope="row"><%=unarticulo.getId()%></th>
                            <td><%=unarticulo.getTitulo()%></td>
                            <td><%=unarticulo.getPrecio()%></td>
                            <td><%=unarticulo.getImagen()%></td>
                            <td><%=unarticulo.getAutor()%></td>
                            <td><%=unarticulo.getCodigo()%></td>
                            <td><%=unarticulo.getFechaCreacion()%></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/EliminarController?id=<%=unarticulo.getId()%>" 
                                    class="btn btn-danger" 
                                    tabindex="-1"
                                    role="button"
                                    aria-disabled="true">
                                    Eliminar
                                </a>
                                <a href="<%=request.getContextPath()%>/EditarController?id=<%=unarticulo.getId()%>" 
                                    class="btn btn-warning" 
                                    tabindex="-1"
                                    role="button"
                                    aria-disabled="true">
                                    Editar
                                </a>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
              </table>
        </div>
      </div>
    </div>
</body>
</html>