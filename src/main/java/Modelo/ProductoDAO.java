package Modelo;

import Config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r ;


    public  List<Producto> obtenerProducto(String nombre){
        String sentencia = "Select * from productos where nombreproducto='" + nombre + "'";
        List<Producto> lista=new ArrayList<>();
        try{
            con= cn.Conexion();
            ps=con.prepareStatement(sentencia);
            rs= ps.executeQuery();

            while (rs.next()){
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setDescripcionProducto(rs.getString("descripcionproducto"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setPrecio(rs.getDouble("precio"));
                lista.add(producto);
            }
        }catch (SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }


}
