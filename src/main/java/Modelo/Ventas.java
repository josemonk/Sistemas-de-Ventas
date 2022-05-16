package Modelo;

import java.sql.Date;

public class Ventas {
    String estado, numeroFactura;
    int idCliente;
    int idEmpleado;
    int idVenta;
    int idproducto;
    double totalVenta;
    Date fecha;

    public Ventas() {
    }

    public Ventas(String estado, String numeroFactura, int idCliente, int idEmpleado, int idVenta, double totalVenta, Date fecha) {
        this.estado = estado;
        this.numeroFactura = numeroFactura;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idVenta = idVenta;
        this.totalVenta = totalVenta;
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
}
