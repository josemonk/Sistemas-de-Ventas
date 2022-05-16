package Modelo;

public class Producto {
        int id;
        String nombreProducto,descripcionProducto,unidad;
        double precio;

        public Producto() {
        }

        public Producto(int id, String nombreProducto, String descripcionProducto, String unidad, double precio) {
                this.id = id;
                this.nombreProducto = nombreProducto;
                this.descripcionProducto = descripcionProducto;
                this.unidad = unidad;
                this.precio = precio;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getNombreProducto() {
                return nombreProducto;
        }

        public void setNombreProducto(String nombreProducto) {
                this.nombreProducto = nombreProducto;
        }

        public String getDescripcionProducto() {
                return descripcionProducto;
        }

        public void setDescripcionProducto(String descripcionProducto) {
                this.descripcionProducto = descripcionProducto;
        }

        public String getUnidad() {
                return unidad;
        }

        public void setUnidad(String unidad) {
                this.unidad = unidad;
        }

        public double getPrecio() {
                return precio;
        }

        public void setPrecio(double precio) {
                this.precio = precio;
        }
}


