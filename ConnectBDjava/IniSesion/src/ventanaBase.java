import javax.swing.*;

public class ventanaBase {
    protected JFrame frame;

    // Constructor
    public ventanaBase(String titulo) {
        frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la ventana y terminar el programa
    }

    // Método para mostrar la ventana
    public void mostrarVentana() {
        frame.pack(); // Ajustar el tamaño de la ventana a los componentes
        frame.setVisible(true);
    }

    // Método para cerrar la ventana
    public void cerrarVentana() {
        frame.dispose(); // Liberar los recursos y cerrar la ventana
    }
}

