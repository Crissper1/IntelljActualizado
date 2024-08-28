public class cosa {
    private String nombre;
    private int cantidad;

    public cosa(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int noEsMucho(){
        if (this.cantidad >= 4){
            return cantidad-4;
        }
        else {
            return 0;
        }
    }
    public String mostrar(){
        return String.format("Nombre %s - Cantidad %d", this.nombre, this.cantidad);

    }
}
