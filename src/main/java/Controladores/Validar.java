package Controladores;

import Modelo.Usuario;
import Modelo.UsuarioDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Validar", value = "/Validar")
public class Validar extends HttpServlet {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            int documento = Integer.parseInt(request.getParameter("txtusuario"));
            String pass = request.getParameter("txtpassword");
            usuario = usuarioDAO.Validar(documento, pass);
            if (usuario.getNombre() != null) {
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("controlador?menu=Principal").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
