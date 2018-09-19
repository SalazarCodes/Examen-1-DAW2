package Conexion;

import Entidades.Productos;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connection {
    
    private String Driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/cibertec2018";
    private String Usuario = "root";
    private String Clave = "mysql";
    private java.sql.Connection Cn;
    private Statement Cmd;
    private CallableStatement Stmt;
    private ResultSet Rs;
    private ArrayList<Productos> Lista;
    
    public Connection() {
        try {
            Class.forName(Driver);
            Cn = DriverManager.getConnection(URL, Usuario, Clave);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("*** ERROR:"+e.getMessage());
        }
    }
    
     public ArrayList<Productos> Listado(){
        String SQL = "CALL listar_productos()";
        Lista = new ArrayList<>();
        try {
                Stmt = Cn.prepareCall(SQL);
                Rs = Stmt.executeQuery();
                while(Rs.next()){
                    Lista.add(new Productos(
                            Rs.getString("idProducto"),
                            Rs.getString("descripcion"),
                            Rs.getString("precio"),
                            Rs.getString("stock")                            
                    ));
                }
        } catch (SQLException e) {
                System.out.println("*** ERROR:"+e.getMessage());
        }
        return Lista;
    }
     
     public void Insertar(Productos ObjP){
        String SQL = "CALL inserta_producto(?,?,?,?)";
        try {
                Stmt = Cn.prepareCall(SQL);
                Stmt.setString(1, ObjP.getIdProducto());
                Stmt.setString(2, ObjP.getDescripcion());
                Stmt.setString(3, ObjP.getPrecio());
                Stmt.setString(4, ObjP.getStock());
                Stmt.executeUpdate();
        } catch (SQLException e) {
                System.out.println("*** ERROR:"+e.getMessage());
        }
    }
    
     public void Modificar(Productos ObjP){
        String SQL = "CALL editar_producto(?,?,?,?)";
        try {
                Stmt = Cn.prepareCall(SQL);
                Stmt.setString(1, ObjP.getIdProducto());
                Stmt.setString(2, ObjP.getDescripcion());
                Stmt.setString(3, ObjP.getPrecio());
                Stmt.setString(4, ObjP.getStock());
                Stmt.executeUpdate();
        } catch (SQLException e) {
                System.out.println("*** ERROR:"+e.getMessage());
        }
    }
     
       public void Eliminar(String id){
        String SQL = "CALL elimina_producto(?)";
        try {
                Stmt = Cn.prepareCall(SQL);
                Stmt.setString(1, id);
                Stmt.executeUpdate();
        } catch (SQLException e) {
                System.out.println("*** ERROR:"+e.getMessage());
        }
    }
        public Productos Buscar(String Id){
        String SQL = "CALL buscar_producto(?)";
        Productos ObjP = null;
        try {
                Stmt = Cn.prepareCall(SQL);
                Stmt.setString(1, Id);
                Rs = Stmt.executeQuery();
                if(Rs.next()){
                    ObjP = new Productos(Rs.getString("idProducto"),
                            Rs.getString("descripcion"),
                            Rs.getString("precio"),
                            Rs.getString("stock")) ;
                }
        } catch (SQLException e) {
                System.out.println("*** ERROR:"+e.getMessage());
        }
        return ObjP;
    }
     
}
