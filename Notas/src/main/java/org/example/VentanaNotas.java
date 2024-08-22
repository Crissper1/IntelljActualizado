package org.example;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNotas extends JFrame {

    private JTextField txtFildMateria;
    private JTextField txtFildNotas;
    private JButton btnAgregar;
    private JButton btnBorrar;
    private JButton btnVaciar;
    private JList jListMuestra;
    private JPanel panelMain;
    private JLabel labelAltas;
    private JLabel labelBajas;
    private JLabel labelPromedio;
    private int contadorAltas = 0;
    private int contadorBajas = 0;
    String nota = "";


    public VentanaNotas() {

        // Set the title of the window
        setTitle("Ventana Notas");

        // Set the size of the window
        setSize(500, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window
        setLocationRelativeTo(null);

        //Agregar a la JList
        DefaultListModel<String> model = new DefaultListModel<>();
        jListMuestra.setModel(model);
        ((AbstractDocument) txtFildNotas.getDocument()).setDocumentFilter(new textfild());

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String materia = txtFildMateria.getText();
                nota = txtFildNotas.getText();
                if (materia.isEmpty() || nota.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese la materia y la nota", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String resumen = String.format("Materia: %s - Nota: %s", materia, nota);
                model.addElement(resumen);
                int nota = Integer.parseInt(txtFildNotas.getText());
                if (nota >= 8) {
                    contadorAltas++;
                } else {
                    contadorBajas++;
                }
                txtFildMateria.setText("");
                txtFildNotas.setText("");
                actualizarContadores();
                actualizarPromedio();
            }

        });
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jListMuestra.getSelectedIndex();
                if (index != -1) {
                    String item = model.getElementAt(index);
                    String[] parts = item.split(" - Nota: ");
                    int notaItem = Integer.parseInt(parts[1]);
                    if (notaItem >= 8) {
                        contadorAltas--;
                    } else {
                        contadorBajas--;
                    }
                        labelAltas.setText(String.valueOf(contadorAltas));
                        labelBajas.setText(String.valueOf(contadorBajas));
                    }else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un elemento para borrar", "Error", JOptionPane.ERROR_MESSAGE);
                }

                    model.remove(index);
                    actualizarPromedio();

            }

        });
        btnVaciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.clear();
                actualizarContadores();
                actualizarPromedio();
            }
        });
    }

    private void actualizarContadores() {
        DefaultListModel<String> model = (DefaultListModel<String>) jListMuestra.getModel();
        int totalNotas = model.getSize();

            for (int i = 0; i < totalNotas; i++) {
                String item = model.getElementAt(i);
                String[] parts = item.split(" - Nota: ");
                int notaItem = Integer.parseInt(parts[1]);
                if (totalNotas == 0) {
                    labelAltas.setText("n/a");
                    labelBajas.setText("n/a");
                    labelPromedio.setText("n/a");
                }
                if (notaItem >= 8) {
                    labelAltas.setText(String.valueOf(contadorAltas));

                } else {
                    labelBajas.setText(String.valueOf(contadorBajas));

                }
            }
            labelAltas.setText(String.valueOf(contadorAltas));
            labelBajas.setText(String.valueOf(contadorBajas));



    }

    private void actualizarPromedio() {
        DefaultListModel<String> model = (DefaultListModel<String>) jListMuestra.getModel();
        int totalNotas = model.getSize();
        int sumaNotas = 0;
        for (int i = 0; i < totalNotas; i++) {
            String item = model.getElementAt(i);
            String[] parts = item.split(" - Nota: ");
            int nota = Integer.parseInt(parts[1]);
            sumaNotas += nota;
        }
        double promedio = (double) sumaNotas / totalNotas;
        labelPromedio.setText(String.valueOf(promedio));
    }




    public static void main(String[] args) {

        // Create and display the window
        VentanaNotas ventana = new VentanaNotas();
        ventana.setContentPane(ventana.panelMain);
        // Hacer visible el JFrame
        ventana.setVisible(true);


    }
}
