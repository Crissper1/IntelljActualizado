import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad: "));
        cosa c = new cosa(nombre, cantidad);
        JOptionPane.showMessageDialog(null, c.mostrar());
        JOptionPane.showMessageDialog(null, c.noEsMucho());

    }
}