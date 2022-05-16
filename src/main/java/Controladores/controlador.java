package Controladores;

import Modelo.Cliente;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Modelo.VentasDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controlador", value = "/controlador")
public class controlador extends HttpServlet {
            Usuario usuario = new Usuario();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Cliente cliente = new Cliente();
            VentasDAO ventasDAO = new VentasDAO();
            int idusuario;
            int idcliente;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");

        if (menu.equals("Clientes")) {

                switch (accion) {
                    case "Listar":
                        List lista = usuarioDAO.listarPorRol("Cliente");
                        request.setAttribute("usuarios", lista);
                        break;
                }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Productos")) {
            request.getRequestDispatcher("Productos.jsp").forward(request, response);
        }
        if (menu.equals("Empleados")) {
            switch (accion) {
                case "Listar":
                    List lista = usuarioDAO.listarPorRol("Empleado");
                    request.setAttribute("usuarios", lista);
                    break;
                case "Cargar":
                    idusuario = Integer.parseInt(request.getParameter("id"));
                    Usuario usuario = usuarioDAO.ListarPorId(idusuario);
                    request.setAttribute("usuarioSeleccionado", usuario);
                    request.getRequestDispatcher("controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idusuario = Integer.parseInt(request.getParameter("id"));
                    usuarioDAO.Eliminar(idusuario);
                    request.getRequestDispatcher("controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empleados.jsp").forward(request, response);
        }
        if(menu.equals("Ventas")){
            switch (accion){
                case "Listar":
                    List lista = ventasDAO.ventasList();
                    request.setAttribute("ventas", lista);
                    break;
            }
                    request.getRequestDispatcher("Ventas.jsp").forward(request,response);

        }

            }






    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");

        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleados")&& accion.equals("Agregar")) {
            int documento = Integer.parseInt(request.getParameter("txtdocumento"));
            String nombre = request.getParameter("txtnombre");
            String correo = request.getParameter("txtcorreo");
            String password = request.getParameter("txtpassword");
            String rol = request.getParameter("txtrol");
            String estado = request.getParameter("txtestado");
            usuario.setDocumento(documento);
            usuario.setNombre(nombre);
            usuario.setPassword(password);
            usuario.setCorreo(correo);
            usuario.setRol(rol);
            usuario.setEstado(estado);
            usuarioDAO.Agregar(usuario);
            request.getRequestDispatcher("controlador?menu=Empleados&accion=Listar").forward(request,response);
            request.getRequestDispatcher("Empleados.jsp").forward(request, response);
        }

        if(accion!=null){
            switch (accion) {

                case "BuscarCliente":
                    int documentoCliente=Integer.parseInt(request.getParameter("documentocliente"));
                    usuario=usuarioDAO.BuscarCliente(documentoCliente);
                    request.setAttribute("cliente",usuario);
                    request.getRequestDispatcher("Ventas.jsp").forward(request,response);
                    break;

                case "Eliminar":
                    idusuario = Integer.parseInt(request.getParameter("id"));
                    usuarioDAO.Eliminar(idusuario);
                    response.sendRedirect("controlador?menu=Empleados&accion=Listar");
                    break;

                case "Actualizar":
                    int documentoUpdate = Integer.parseInt(request.getParameter("txtdocumento"));
                    String nombreUpdate = request.getParameter("txtnombre");
                    String passwordUpdate = request.getParameter("txtpassword");
                    String correoUpdate = request.getParameter("txtcorreo");
                    String rolUpdate = request.getParameter("txtrol");
                    String estadoUpdate = request.getParameter("txtestado");
                    usuario.setDocumento(documentoUpdate);
                    usuario.setNombre(nombreUpdate);
                    usuario.setPassword(passwordUpdate);
                    usuario.setCorreo(correoUpdate);
                    usuario.setRol(rolUpdate);
                    usuario.setEstado(estadoUpdate);
                    usuario.setId(idusuario);
                    usuarioDAO.Actualizar(usuario);
                    request.getRequestDispatcher("controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;
            }
        }
    }
}