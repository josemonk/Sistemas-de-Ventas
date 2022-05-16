package Config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class validar_cone {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        try {
            Connection cone = con.Conexion();

            Statement instruccion = cone.createStatement();

            String SQL = "SELECT * FROM usuarios";

            ResultSet resultado = instruccion.executeQuery(SQL);

            while (resultado.next()){
                System.out.println("nombre: " + resultado.getString("nombre") + " correo: " + resultado.getString("correo")+"password:  "+resultado.getString("password"));
            }

            resultado.close();
            instruccion.close();
            cone.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
