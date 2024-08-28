public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(int codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    // Getters and Setters


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //Metodos
    public Boolean esDisponible(){
        return this.stock > 0;
    }
    public String mostrarInfo(){
        return String.format("Codigo: %d, Nombre: %s, Precio: %.2f", this.codigo, this.nombre, this.precio);
    }

}
