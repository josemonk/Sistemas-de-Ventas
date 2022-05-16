package Modelo;

import Config.Conexion;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentasDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r ;
    Ventas ventas= new Ventas();


    public void insertarVenta( Ventas ventas){
        String setencia = "insert into  ventas (numerofactura,idclienteventa,idempleadoventa,fechaventa,totalventa,idproducto) values(?,?,?,?,?,?)";

         try{
             con= cn.Conexion();
             ps= con.prepareStatement(setencia);
             ps.setString(1,ventas.getNumeroFactura());
             ps.setInt(2,0);
             ps.setInt(3,ventas.getIdEmpleado());
             ps.setDate(4, (Date) ventas.getFecha());
             ps.setDouble(5,ventas.getTotalVenta());
             ps.setInt(6,ventas.getIdproducto());
             ps.executeUpdate();


         }catch (SQLException ex){
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    public List<Ventas>ventasList(){
        String sentencia = "select*from ventas";
        List<Ventas>lista = new ArrayList<>();

        try{
            con= cn.Conexion();
            ps= con.prepareStatement(sentencia);
            rs= ps.executeQuery();

            while(rs.next()){
                Ventas ventas=new Ventas();
                ventas.setIdVenta(rs.getInt("idventa"));
                ventas.setNumeroFactura(rs.getString("numerofactura"));
                ventas.setIdCliente(rs.getInt("idclienteventa"));
                ventas.setIdEmpleado(rs.getInt("idempleadoventa"));
                ventas.setFecha(rs.getDate("fechaventa"));
                ventas.setTotalVenta(rs.getDouble("totalventa"));
                ventas.setIdproducto(rs.getInt("idproducto"));
                lista.add(ventas);
            }

        }catch (SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }


}
