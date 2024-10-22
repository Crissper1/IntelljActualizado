import javax.swing.*;

public class ventanaMensaje extends ventanaBase {
    private JComboBox comboContactos;
    private JLabel aId;
    private JTextArea textArea1;
    private JButton enviarButton;
    private JPanel JpanelMensaje;

    // Constructor que recibe el nombre de usuario
    public ventanaMensaje(String nombreUsuario) {
        super("Mensaje");

        // Configuración del frame
        frame.setContentPane(JpanelMensaje);

        // Establecer el nombre del usuario en la etiqueta aId
        aId.setText(nombreUsuario);
    }

    // Método para obtener el frame
    public JFrame getFrame() {
        return frame;
    }
}
