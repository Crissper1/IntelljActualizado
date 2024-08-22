package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ventana extends JFrame {
    private JPanel panelMain;
    private JTextField textField1;
    private JButton btn1;
    private JButton btn4;
    private JList list2;
    private JButton btn2;
    private JButton btn3;
    private JList list1;
    private JButton btnx10;
    private JPanel panelList1;
    private JPanel panelList2;


    public ventana() {
        if (!(list1.getModel() instanceof DefaultListModel)) {
            list1.setModel(new DefaultListModel<>());
        }
        if (!(list2.getModel() instanceof DefaultListModel)) {
            list2.setModel(new DefaultListModel<>());
        }

        DefaultListModel<String> apostar = (DefaultListModel<String>) list1.getModel();
        DefaultListModel<String> sorteados = (DefaultListModel<String>) list2.getModel();

        JList<String> miLista1 = new JList<>(apostar);
        JList<String> miLista2 = new JList<>(sorteados);

        // Crear un JScrollPane y pasarle el JList como argumento
        JScrollPane scrollPane1 = new JScrollPane(miLista1);
        JScrollPane scrollPane2 = new JScrollPane(miLista2);

        panelList1.add(scrollPane1);
        panelList2.add(scrollPane2);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(btn1, "Número agregado");
                String elemento = textField1.getText().trim();
                if (!elemento.isEmpty()) {
                    try {
                        int n= Integer.parseInt(elemento);

                        if(n > 0 && n < 999 ){
                            apostar.addElement(elemento);
                        }else {
                            JOptionPane.showMessageDialog(btn1,"Fuera de Rango 0 a 999");
                        }

                    }catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(btn1, "Solo se permite Números");
                    }
                }textField1.setText("");
            }

        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = miLista1.getSelectedIndex();
                if (indiceSeleccionado != -1) { // Verificar si hay un elemento seleccionad
                    apostar.remove(indiceSeleccionado); // Borrar el elemento del modelo
                }else {
                    JOptionPane.showMessageDialog(btn3,"Seleccione un elemento");
                }
            }

        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostar.clear(); // Limpiar todos los elementos del modelo
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int size = apostar.getSize(); // Obtener el número de elementos en la lista apostar

                int sizeOriginal = apostar.getSize(); // Obtener el número de elementos en la lista apostar

                if (sizeOriginal > 0) {
                    Set<Integer> numerosSorteados = new HashSet<>(); // Conjunto para almacenar los números sorteados
                    Random random = new Random();

                    // Generar 20 números aleatorios únicos
                    while (numerosSorteados.size() < 20) {
                        int numeroAleatorio = random.nextInt(999); // Genera un número entre 1 y 999
                        numerosSorteados.add(numeroAleatorio);
                    }

                    // Agregar los números sorteados a la lista "sorteados"
                    sorteados.clear(); // Limpiar la lista antes de agregar nuevos elementos
                    for (int numero : numerosSorteados) {
                        sorteados.addElement(String.valueOf(numero));
                    }

                    // Colorear los números iguales en ambas listas
                    pintarCoincidencias();

                } else {
                    JOptionPane.showMessageDialog(null, "La lista está vacía.");
                }
            }

            private void pintarCoincidencias() {
                // Obtener los modelos de ambas listas
                DefaultListModel<String> modelApostar = (DefaultListModel<String>) miLista1.getModel();
                DefaultListModel<String> modelSorteados = (DefaultListModel<String>) miLista2.getModel();

                // Listas para almacenar los índices de las coincidencias en cada lista
                List<Integer> indicesCoincidentesApostar = new ArrayList<>();
                List<Integer> indicesCoincidentesSorteados = new ArrayList<>();

                // Recorrer la lista de sorteados y buscar coincidencias en la lista de apuestas
                for (int i = 0; i < modelSorteados.getSize(); i++) {
                    String numeroSorteado = modelSorteados.getElementAt(i);

                    // Buscar el número sorteado en la lista de apuestas
                    int indiceEnApostar = modelApostar.indexOf(numeroSorteado);

                    // Si se encuentra una coincidencia, almacenar los índices
                    if (indiceEnApostar != -1) {
                        indicesCoincidentesApostar.add(indiceEnApostar);
                        indicesCoincidentesSorteados.add(i);
                    }
                }

                // Colorear todas las filas coincidentes
                miLista1.setCellRenderer(new MiListCellRenderer(indicesCoincidentesApostar));
                miLista2.setCellRenderer(new MiListCellRenderer(indicesCoincidentesSorteados));


                // Construir el mensaje con los números coincidentes
                if  (indicesCoincidentesApostar.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias entre las listas.");
                }
                else {
                    StringBuilder mensaje;
                    mensaje = new StringBuilder("¡Coincidencias encontradas! Los siguientes números están en ambas listas:\n");
                    for (int i = 0; i < indicesCoincidentesSorteados.size(); i++) {
                        mensaje.append(modelSorteados.getElementAt(indicesCoincidentesSorteados.get(i)));
                        if (i < indicesCoincidentesSorteados.size() - 1) {
                            mensaje.append(", ");
                        }
                        // Mostrar el mensaje
                        JOptionPane.showMessageDialog(null, mensaje.toString());
                    }
                }

            }
            // Clase MiListCellRenderer
            class MiListCellRenderer extends DefaultListCellRenderer {
                    private final List<Integer> filasAColorear;

                    public MiListCellRenderer(List<Integer> filasAColorear) {
                        this.filasAColorear = filasAColorear;
                    }

                    @Override
                    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);


                        // Verificar si el índice actual está en el conjunto de filas a colorear
                        if (filasAColorear.contains(index)) {
                            c.setBackground(Color.cyan); // Colorear las coincidencias
                        } else {
                            c.setBackground(miLista1.getBackground());
                            c.setBackground(miLista2.getBackground());// Restaurar el color predeterminado si no es una coincidencia
                        }

                        return c;
                    }
                }

        });
        btnx10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Random rand = new Random();
                while (apostar.size() < 99) {
                    int numeroAleatorio = rand.nextInt(999); // Genera un número entre 0 y 999
                        apostar.addElement(String.valueOf(numeroAleatorio));

                }
            }
        });
    }

    public static void main(String[] args) {
        // Crear el JFrame
        ventana h = new ventana();

        h.setContentPane(h.panelMain);

        // Configurar el JFrame (tamaño, posición, etc.)
        h.setSize(350, 200);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Hacer visible el JFrame
        h.setVisible(true);
    }


}
