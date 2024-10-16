import javax.swing.*;

public class ventanaBase {
    protected JFrame frame;

    // Constructor
    public ventanaBase(String titulo) {
        frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //Metodo para mostrar la ventana
    public void mostrarVentana(){
        frame.pack();
        frame.setVisible(true);
    }

    //Metodo para cerrar la ventana
    public void cerrarVentana(){
        frame.setVisible(false);
    }
}
