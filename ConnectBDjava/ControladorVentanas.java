

import javax.swing.JFrame;


public class ControladorVentanas {
    private ventanaLogin ventanaPrincipal;
    private JFrame ventanaSecundaria;

    public ControladorVentanas() {
        ventanaPrincipal = new ventanaLogin();
        ventanaSecundaria = new JFrame("Ventana Secundaria");
        ventanaSecundaria.setSize(400, 300);
        ventanaSecundaria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mostrarVentanaPrincipal() {
        //ventanaPrincipal.setVisible(true);
        ventanaSecundaria.setVisible(false); // Ocultar la ventana secundaria si está visible
    }

    public void mostrarVentanaSecundaria() {
        ventanaSecundaria.setVisible(true);
//        ventanaPrincipal.setVisible(false); // Ocultar la ventana principal si está visible
    }

    public void ocultarVentanaSecundaria() {
        ventanaSecundaria.setVisible(false);
    }
}