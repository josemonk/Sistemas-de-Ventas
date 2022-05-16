package Controladores;

import Modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@WebServlet(name = "ventas", value = "/ventas")
public class ServletVentas extends HttpServlet {
    ProductoDAO productoDAO = new ProductoDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    VentasDAO ventasDAO = new VentasDAO();
    Ventas ventas = new Ventas();
    Usuario usuario = new Usuario();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        }


    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menu = request.getParameter("menu");
       String accion = request.getParameter("accion");
        String documento=   request.getParameter("documentocliente");
     String nombreProducto=  request.getParameter("Producto");
     String dias=  request.getParameter("cantidadDias");
     String personas =  request.getParameter("cantidadPersonas");

     Producto producto = productoDAO.obtenerProducto(nombreProducto).get(0);
     Usuario usuario = usuarioDAO.ListarPorDocumento(documento);


     double descuento = obtenerDescuento(producto.getNombreProducto(), Integer.parseInt(dias), Integer.parseInt(personas));
     double total =  (Integer.parseInt(dias) * producto.getPrecio()) * (1 - descuento) ;


     //1 llamar un método del dao de la venta que le sirva para guardar (total, cliente, fecha etc...)
       int idusuario= usuario.getId();
       int idproducto = producto.getId();
       String numeroFactura="1";
       ventas.setIdEmpleado(idusuario);
       ventas.setTotalVenta(total);
       ventas.setFecha(new Date(Calendar.getInstance().getTime().getTime()));
       ventas.setNumeroFactura(numeroFactura);
       ventas.setIdproducto(idproducto);
       ventasDAO.insertarVenta(ventas);





        //2. llamar el método para listar en la vista
            //clase nueva
            //recorre cada venta, sacar el id del productor, ir a la base de datos y consultar en la tabla productos el producto que tenga ese id, crear una instancia de tablaVentas y ponerle los datos de la venta + el nombre del producto, por úlitmo agregar el objeto tablaVentas a una lista de objetos tablaVentas
        ventasDAO.ventasList().get(1);


 

    }







    private double obtenerDescuento(String producto, int dias, Integer personas){

        if(producto.equals("Individual")){
            if(dias <=10){
                return 0;
            }else if (dias>=11 &&dias<=15 ){
                return 0.1;
            }else {
                return 0.15;
            }
        }

        else if(producto.equals("Pareja")){
            if(dias <=10){
                return 0;
            }else if (dias>=11 &&dias<=15 ){
                return 0.15;
            }else {
                return 0.20;
            }
        }
        else{
            double descuento = 0;

            if (dias>=11 &&dias<=15 ){
                descuento = 0.17;
            }else if(dias >= 16) {
                descuento =  0.22;
            }

            if(personas != null && personas >= 5 && personas <= 7) {
                descuento = descuento + 0.03;
            }
            else if (personas != null && personas >= 8){
                descuento = descuento + 0.05;
            }
            return  descuento;
        }
    }
}
