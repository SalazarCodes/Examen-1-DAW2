package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidades.Productos;
import Conexion.Connection;

public class grabar extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Productos ObjA = null;
            Connection ObjBD = new Connection();
            String Id = null;
            int op = Integer.parseInt(request.getParameter("op"));
            if(op != 2){
                ObjA = new Productos(
                        request.getParameter("txtid"),
                        request.getParameter("txtdesc"),
                        request.getParameter("txtprec"),
                        request.getParameter("txtstock"));
            }else{
                        Id = request.getParameter("txtid");
            }
            // Evaluar el valor de op
            switch (op) {
                case 1: ObjBD.Modificar(ObjA); break;
                case 2: ObjBD.Eliminar(Id); break;
                case 3: ObjBD.Insertar(ObjA);break;
            }
            // Redireccionar a la pagina principal
            response.sendRedirect("index.jsp");
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
