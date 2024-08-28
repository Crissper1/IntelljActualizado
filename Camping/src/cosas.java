public class cosas {
    String nombre;
    int cantidad;

    public cosas(String nombre, int cantidad){
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

    public String mostrar(String nombre, int cantidad){
        return String.format("%s-%d", nombre, cantidad);
    }
}
