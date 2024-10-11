import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ventana {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton cancelarButton;
    private JButton enviarButton;
    private JPanel Jpanel;





    public ventana() {
        JFrame frame = new JFrame("ventana");
        frame.setContentPane(this.Jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new instance of BaseDeDatos
                BaseDeDatos bd = new BaseDeDatos();
                // Create a new instance of PreparedStatement
                PreparedStatement ps = null;
                try {
                    ps = bd.getConexion().prepareStatement("Select * FROM login.persona WHERE login = ? AND pass = ?");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                // Set the first parameter
                try {
                    ps.setString(1, textField1.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                // Set the second parameter
                try {
                    ps.setString(2, passwordField1.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                // Execute the query
                bd.ejecutarSQL(ps);
                // If the query returns a result
                try {
                    if(bd.getResultado().next()){
                        JOptionPane.showMessageDialog(null, "Bienvenido");
                        //Muestra un mensaje con la descripcion
                        JOptionPane.showMessageDialog(null, "Descripcion: " + bd.getResultado().getString("nombre"));
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);


            }
        });
    }
}
