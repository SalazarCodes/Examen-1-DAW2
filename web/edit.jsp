<%@page import="Entidades.Productos" %>
<%@page import="Conexion.Connection" %>
<%
    String Id = request.getParameter("id");
    Connection ObjBD = new Connection();
    Productos ObjP = new Productos();
    ObjP = ObjBD.Buscar(Id);
%>
<center>
    <h1>Editar datos de producto</h1>
    <table border="1">
    <form action="grabar">
        <input type="hidden" name="op" value="1">
        <tr>
            <td>IdProducto</td>
            <td><input name="txtid" value=<%=ObjP.getIdProducto()%> readonly></td>
        </tr>
        <tr>
            <td>Descripcion</td>
            <td><input name="txtdesc" value='<%=ObjP.getDescripcion()%>'></td>
        </tr>
        <tr>
            <td>Precio</td>
            <td><input name="txtprec" value='<%=ObjP.getPrecio()%>'></td>
        </tr>
        <tr>
            <td>Stock</td>
            <td><input name="txtstock" value=<%=ObjP.getStock()%>></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
            <td><input type="reset"></td>
        </tr>
    </form>
    </table>
        <a href="index.jsp">Regresar</a>
</center>
