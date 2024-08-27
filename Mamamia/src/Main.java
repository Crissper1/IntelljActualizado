import javax.swing.*;

public class Main {
    public static void main(String[] args) {



        //Pruebas
        int cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto"));
        Producto producto = new Producto(cod, nombre, precio, stock);
        JOptionPane.showMessageDialog(null, producto.mostrarInfo());
        if (producto.esDisponible()) {
            JOptionPane.showMessageDialog(null, "El producto esta disponible");
        } else {
            JOptionPane.showMessageDialog(null, "El producto no esta disponible");
        }


    }
}