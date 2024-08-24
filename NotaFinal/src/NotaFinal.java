import javax.swing.*;

public class NotaFinal {
    public static void main(String[] args) {
        int ci = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su CI"));
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        String apellido = JOptionPane.showInputDialog("Ingrese su apellido");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
        Estudiantes estudiante = new Estudiantes(ci, nombre, apellido, edad);
        JOptionPane.showMessageDialog(null, estudiante.mostrar());
        if (estudiante.esMayorEdad()) {
            JOptionPane.showMessageDialog(null, "Es mayor de edad");
        } else {
            JOptionPane.showMessageDialog(null, "No es mayor de edad");
        }


    }
}
