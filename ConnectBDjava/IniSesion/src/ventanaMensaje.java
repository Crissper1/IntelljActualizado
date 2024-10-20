import javax.swing.*;

public class ventanaMensaje extends ventanaBase {
    private JComboBox comboContactos;
    private JLabel aId;
    private JTextArea textArea1;
    private JButton enviarButton;
    private JPanel JpanelMensaje;

    public ventanaMensaje(String titulo) {
        super("Mensaje");

        // Agregar el panel generado por el editor de componentes de IntelliJ al frame
        frame.setContentPane(JpanelMensaje);


    }

}
