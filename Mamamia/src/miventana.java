import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class miventana {

    private JPanel PanelMain;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JList list1;
    private JButton btnAgregar;
    private JLabel labelTotal;
    private JLabel labelPorcentaje;
    private JLabel labelValorTotal;

    public miventana() {
        //Crea la ventana
        JFrame frame = new JFrame("miventana");
        frame.setContentPane(this.PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        //Inicializa la lista
        DefaultListModel<String> model = new DefaultListModel<>();
        list1.setModel(model);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Obtener valores de los campos
                try {
                int cod = Integer.parseInt(textField1.getText());
                String nombre = textField2.getText();
                double precio = Double.parseDouble(textField3.getText());
                int stock = Integer.parseInt(textField4.getText());
                //Crear el producto
                Producto producto = new Producto(cod, nombre, precio, stock);
                //Agregar el producto a la lista, cod solo numeros y nombre solo letras no vacio

                    if (cod > 0 && nombre.matches("[a-zA-Z]+") && !nombre.isEmpty() && precio > 0 && stock >= 0) {
                        model.addElement(producto.mostrarInfo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese valores validos");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese valores validos");
                }
                labelTotal.setText(String.valueOf(model.getSize()));
                //Calcular el porcentaje de productos con stock
                int total = 0;
                for (int i = 0; i < model.getSize(); i++) {
                    String[] parts = model.getElementAt(i).split(",");
                    String part2 = parts[2].trim();
                    if (Integer.parseInt(part2) > 0) {
                        total++;
                    }
                }




            }
        });
    }

    public static void main(String[] args) {
        new miventana();
    }
}
