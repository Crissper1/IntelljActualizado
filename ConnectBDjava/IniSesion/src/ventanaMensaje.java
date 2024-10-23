import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ventanaMensaje extends ventanaBase {
    private JComboBox comboContactos;
    private JLabel aId;
    private JTextArea textArea1;
    private JButton enviarButton;
    private JPanel JpanelMensaje;


    // Constructor que recibe el nombre de usuario
    public ventanaMensaje(String nombreUsuario) {
        super("Mensaje");

        // Llenar el comboBox con los nombres de usuarios, excluyendo el actual
        cargarUsuariosEnCombo(nombreUsuario);

        // Configuración del frame
        frame.setContentPane(JpanelMensaje);

        // Establecer el nombre del usuario en la etiqueta aId
        aId.setText(nombreUsuario);
    }

    // Método para cargar usuarios en el comboBox
    private void cargarUsuariosEnCombo(String nombreUsuario) {
        BaseDeDatos bd = new BaseDeDatos();
        PreparedStatement ps;

        try {
            ps = bd.getConexion().prepareStatement("SELECT nombre FROM persona WHERE nombre != ?");
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                comboContactos.addItem(rs.getString("nombre"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar usuarios: " + ex.getMessage());
        }
    }

    // Método para enviar mensaje
    private void enviarMensaje() {
        String receptor = (String) comboContactos.getSelectedItem(); // Obtener receptor del comboBox
        String mensaje = textArea1.getText(); // Obtener el mensaje del textArea

        if (receptor == null || receptor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un receptor.");
            return;
        }

        if (mensaje.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El cuadro de mensaje está vacío.");
            return;
        }

        // Guardar mensaje en la base de datos
        BaseDeDatos bd = new BaseDeDatos();
        PreparedStatement ps;

        try {
            ps = bd.getConexion().prepareStatement(
                    "INSERT INTO mensajes (emisor, receptor, mensaje) VALUES (?, ?, ?)"
            );
            ps.setString(1, nombreUsuario); // El usuario actual es el emisor
            ps.setString(2, receptor); // El receptor es el seleccionado en el comboBox
            ps.setString(3, mensaje); // El mensaje es el texto ingresado

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Mensaje enviado exitosamente.");

            // Limpiar el cuadro de texto después de enviar el mensaje
            textArea1.setText("");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al enviar mensaje: " + ex.getMessage());
        }
    }


    // Método para obtener el frame
    public JFrame getFrame() {
        return frame;
    }
}
