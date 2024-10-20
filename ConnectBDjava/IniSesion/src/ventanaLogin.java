import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 public class ventanaLogin extends ventanaBase {
    private JPanel JpanelLogin;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton cancelarButton;
     private JButton mensajesButton;



     // Constructor
    public ventanaLogin() {
        super("Login");

        // Agregar el panel generado por el editor de componentes de IntelliJ al frame
        frame.setContentPane(JpanelLogin);



        // Acciones de los botones
        mensajesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear instancia de ventanaMensaje
                ventanaMensaje ventanaMensaje = new ventanaMensaje("Mensaje");
                // Abrir la ventana
                WindowManager.getInstance().openWindow(ventanaMensaje.getFrame());



            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear la conexión con la base de datos
                BaseDeDatos bd = new BaseDeDatos();
                PreparedStatement ps;

                try {
                    ps = bd.getConexion().prepareStatement("SELECT * FROM persona WHERE login = ? AND pass = ?");
                    ps.setString(1, textField1.getText());
                    ps.setString(2, new String(passwordField1.getPassword()));

                    // Ejecutar consulta
                    bd.ejecutarSQL(ps);

                    if (bd.getResultado().next()) {
                        JOptionPane.showMessageDialog(null, "Bienvenido " + bd.getResultado().getString("nombre"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Salir del programa
            }
        });

    }
}
