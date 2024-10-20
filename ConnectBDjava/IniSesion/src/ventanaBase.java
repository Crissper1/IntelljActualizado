import javax.swing.*;

public class ventanaBase {
    protected JFrame frame;

    // Método para obtener el frame
    public JFrame getFrame() {
        return frame;
    }
    // Constructor
    public ventanaBase(String titulo) {
        frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la ventana y terminar el programa
    }


}

