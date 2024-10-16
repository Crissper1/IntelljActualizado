import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class miVentana {

    private JTextField textFieldNom;
    private JTextField textFieldCant;
    private JButton agregarButton;
    private JList listCosas;
    private JButton borrarTodoButton;
    private JLabel labelTotal;
    private JList listGuarda;
    private JButton guardarButton;
    private JButton borrarButton;
    private JLabel labelPorcentaje;
    private JLabel labelTotaGuard;
    private JPanel PanelMain;


    //Inicializa las lista
    DefaultListModel<String> camping = new DefaultListModel<>();
    DefaultListModel<String> cosasGuardadas = new DefaultListModel<>();

    //Contadores
    public int contadTotaCamping = 0;
    public int contadTotaGuard = 0;
    public double porcentaje = 0;

    public miVentana() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Agrega el texto del textField a la lista solo numero y no vacios

                try {
    String nom = textFieldNom.getText();
    int cantidad = Integer.parseInt(textFieldCant.getText());
    if (cantidad > 0 && !nom.isEmpty()) {
        cosas c = new cosas(nom, cantidad);
        camping.addElement(c.mostrar(nom, cantidad));
        listCosas.setModel(camping);
        textFieldNom.setText("");
        textFieldCant.setText("");
    } else {
        JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
    }
    contadTotaCamping++;
    labelTotal.setText(String.valueOf(contadTotaCamping));
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Ingrese un número válido");
} catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Ocurrió un error: " + ex.getMessage());
}
                contadTotaCamping++;
                labelTotal.setText(String.valueOf(contadTotaCamping));



            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Boarra un elemneto seleccionado de listGuarda y lo restaura a la lista de camping
                if (listGuarda.getSelectedIndex() != -1) {
                    Object selectedValue = listGuarda.getSelectedValue();
                    if (selectedValue != null) {
                        String[] parts = ((String) selectedValue).split("-");
                        String nom = parts[0];
                        int cantidad = Integer.parseInt(parts[1]);
                        cosas c = new cosas(nom, cantidad);
                        camping.addElement(c.mostrar(nom, cantidad));
                        listCosas.setModel(camping);
                        cosasGuardadas.remove(listGuarda.getSelectedIndex());
                        listGuarda.setModel(cosasGuardadas);
                    } else {
                        JOptionPane.showMessageDialog(null, "Seleccione un elemento válido de la lista de cosas.");
                    }
                }
            }
        });


        borrarTodoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Borra todos los elementos de la lista
                camping.removeAllElements();
                cosasGuardadas.removeAllElements();
                listCosas.setModel(camping);
                listGuarda.setModel(cosasGuardadas);
                contadTotaCamping = 0;
                contadTotaGuard = 0;
                labelTotal.setText(String.valueOf(contadTotaCamping));
                labelTotaGuard.setText(String.valueOf(contadTotaGuard));
                labelPorcentaje.setText("0%");

            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Guarda un elemnto seleccionado de la lista de camping a la lista de cosasGuardadas
                if (listCosas.getSelectedIndex() != -1) {
                    String[] parts = ((String) listCosas.getSelectedValue()).split("-");
                    String nom = parts[0];
                    int cantidad = Integer.parseInt(parts[1]);
                    cosas c = new cosas(nom, cantidad);
                    cosasGuardadas.addElement(c.mostrar(nom, cantidad));
                    listGuarda.setModel(cosasGuardadas);
                    camping.remove(listCosas.getSelectedIndex());
                    listCosas.setModel(camping);
                }
                contadTotaGuard++;
                labelTotaGuard.setText(String.valueOf(contadTotaGuard));

                porcentaje = (contadTotaGuard * 100) / contadTotaCamping;
                labelPorcentaje.setText(String.valueOf(porcentaje) + "%");



            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("miVentana");
        frame.setContentPane(new miVentana().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
