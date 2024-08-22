package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventana {

    // Configurar el layout del panel
    private JPanel panel1 = new JPanel(new BorderLayout());
    private JList<String> list1;
    private JList<String> list2;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;

    public ventana() {
        // Inicializar las listas
        list1 = new JList<>();
        list2 = new JList<>();

        // Datos de ejemplo para las listas
        DefaultListModel<String> modeloLista1 = new DefaultListModel<>();
        modeloLista1.addElement("1");
        modeloLista1.addElement("Elemento 2");
        modeloLista1.addElement("Elemento 3");
        modeloLista1.addElement("Elemento 6");
        modeloLista1.addElement("Elemnto 2");
        modeloLista1.addElement("Elemento 3");
        modeloLista1.addElement("Elemto ");
        modeloLista1.addElement("Elemento 2");
        modeloLista1.addElement("Elento 3");

        DefaultListModel<String> modeloLista2 = new DefaultListModel<>();
        modeloLista2.addElement("1");
        modeloLista2.addElement("Otro Elemento 2");
        modeloLista2.addElement("lemento 2");
        modeloLista2.addElement("Eemento 3");
        modeloLista2.addElement("Eleento 6");
        modeloLista2.addElement("Elemnto 2");
        modeloLista2.addElement("Elmento 3");
        modeloLista2.addElement("Elemo ");
        modeloLista2.addElement("Elemento 2");



        list1.setModel(modeloLista1);
        list2.setModel(modeloLista2);

        // Crear los JScrollPanes y agregar las listas
        scrollPane1 = new JScrollPane(list1);
        scrollPane2 = new JScrollPane(list2);

        panel1.add(scrollPane1, BorderLayout.WEST);
        panel1.add(scrollPane2, BorderLayout.EAST);
        panel1.add(button1, BorderLayout.SOUTH);

        // Acción del botón para pintar columnas
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pintarColumnas();
            }
        });
    }

    private void pintarColumnas() {
        DefaultListModel<String> modelo1 = (DefaultListModel<String>) list1.getModel();
        DefaultListModel<String> modelo2 = (DefaultListModel<String>) list2.getModel();

        for (int i = 0; i < modelo1.getSize(); i++) {
            String elemento = modelo1.getElementAt(i);
            if (modelo2.contains(elemento)) {
                list1.setCellRenderer(new FilaRenderer(i)); // Pintar fila en list1
                list2.setCellRenderer(new FilaRenderer(modelo2.indexOf(elemento))); // Pintar fila en list2
            }
        }
    }

    // Clase auxiliar para pintar filas
    class FilaRenderer extends DefaultListCellRenderer {
        private int fila;

        public FilaRenderer(int fila) {
            this.fila = fila;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (index == fila) {
                c.setBackground(Color.BLUE); // Color para las filas coincidentes
            }
            return c;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


