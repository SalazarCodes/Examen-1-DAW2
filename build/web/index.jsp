<%@page import="Entidades.Productos" %>
<%@page import="Conexion.Connection" %>
<%@page import="java.util.ArrayList" %>
<%
    Connection ObjBD = new Connection();
    ArrayList<Productos> Lista = new ArrayList<Productos>();
    Lista = ObjBD.Listado();
    String linkEdit, linkDel, linkDeta;
%>
<center>
    <h1>Mantenimiento de Productos</h1>
    <table border="1">
        <tr>
            <th>IdProducto</th>
            <th>Descripcion</th>
            <th>Precio</th>
            <th>Stock</th>
        </tr>
        <% for(Productos ObjP:Lista){ 
        String Codigo = ObjP.getIdProducto();
        linkEdit = "<a href=edit.jsp?id="+Codigo+">Editar</a>";
        linkDel = "<a href=del.jsp?id="+Codigo+">Suprimir</a>";
        linkDeta = "<a href=deta.jsp?id="+Codigo+">Detalles</a>";
        %>
        <tr>
            <td><%=Codigo%></td>
            <td><%=ObjP.getDescripcion()%></td>
            <td><%=ObjP.getPrecio()%></td>
            <td><%=ObjP.getStock()%></td>
            <td><%=linkEdit%> | <%=linkDel%> | <%=linkDeta%></td>
        </tr>
        <% } %>
    </table>
    <a href="insert.jsp">Nuevo Registro</a>
</center>
