
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {

    private JTextField textFieldNom;
    private JTextField textFieldApe;
    private JButton agregarButton;
    private JButton borrarTodoButton;
    private JButton borrarButton;
    private JList listAgregados;
    private JTextField textFielNota;
    private JButton agregarButton1;
    private JList listExoneara;
    private JList listExamen;
    private JTextField textFieldCi;
    private JLabel labelTotAgrega;
    private JLabel labelTotalExone;
    private JLabel labelPorceExonera;
    private JLabel labelTotExamen;
    private JLabel labelPorcenExamen;
    private JPanel PanelMain;
    private JPanel jpanelAgre;


    public class main extends  JFrame{
        public main(){
            super("Ventana");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setContentPane(PanelMain);
            pack();
            setVisible(true);
        }
    }
        //Define los DefaultListModel
        DefaultListModel<String> ListAgre = new DefaultListModel<>();
        DefaultListModel<String> ListExamen = new DefaultListModel<>();
        DefaultListModel<String> ListExonera = new DefaultListModel<>();

        //Variable para contar los elementos agregados
        public int totalAgregados = 0;


    public void contadores() {

        labelTotAgrega.setText(String.valueOf(ListExamen.size()+ListExonera.size()));

        if (!ListExonera.isEmpty()) {
            labelPorceExonera.setText((ListExonera.size() * 100) / totalAgregados + "%");
        } else {
            labelPorceExonera.setText("0%");
        }

        if (!ListExamen.isEmpty()) {
            labelPorcenExamen.setText((ListExamen.size() * 100) / totalAgregados + "%");
        } else {
            labelPorcenExamen.setText("0%");
        }
        labelTotAgrega.setText(String.valueOf(totalAgregados));
        labelTotalExone.setText(String.valueOf(ListExonera.size()));
        labelTotExamen.setText(String.valueOf(ListExamen.size()));
    }

    public Ventana() {


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Asigna el modelo a la lista
                listAgregados.setModel(ListAgre);

                //Suma a la variable totalAg
                totalAgregados++;

                //If para validar que los campos no esten vacios y que la cedula sea un numero
                if (textFieldNom.getText().isEmpty() || textFieldApe.getText().isEmpty() || textFieldCi.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
                }else {
                    try {
                        int ci = Integer.parseInt(textFieldCi.getText());
                        String nombre = textFieldNom.getText();
                        String apellido = textFieldApe.getText();
                        String texto = String.format(" %d - %s - %s ", ci, apellido, nombre);
                        ListAgre.addElement(texto);
                        contadores();
                        textFieldNom.setText("");
                        textFieldApe.setText("");
                        textFieldCi.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "La cedula debe ser un numero");
                    }

                }
            }
        });
        //Classe verificacion de rango
        ((AbstractDocument) textFielNota.getDocument()).setDocumentFilter(new VerificaRango());


        borrarTodoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListAgre.removeAllElements();
                ListExamen.removeAllElements();
                ListExonera.removeAllElements();
                labelTotAgrega.setText("0");
                labelTotalExone.setText("0");
                labelPorceExonera.setText("0 %");
                labelTotExamen.setText("0");
                labelPorcenExamen.setText("0 %");
                totalAgregados = 0;
            }
        });

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listAgregados.getSelectedIndex() != -1) {
                    ListAgre.remove(listAgregados.getSelectedIndex());
                    totalAgregados--;
                }
                contadores();
            }
        });

        agregarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listExamen.setModel(ListExamen);
                listExoneara.setModel(ListExonera);
                //Obterner elementos de la listAgregados
                int index = listAgregados.getSelectedIndex();
                if (index != -1) {
                    String[] datos = ListAgre.get(index).split("-");
                    int ci = Integer.parseInt(datos[0].trim());
                    String apellido = datos[1].trim();
                    String nombre = datos[2].trim();
                    int nota = Integer.parseInt(textFielNota.getText());
                    Estudiantes estudiante = new Estudiantes(ci, nombre, apellido, 0, nota);
                    if (estudiante.verificarNota()) {
                        ListExonera.addElement(ListAgre.get(index));
                    } else {
                        ListExamen.addElement(ListAgre.get(index));
                    }

                    contadores();
                    ListAgre.remove(index);
                    textFielNota.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Por favor seleccione un estudiante");
                }
            }


        });

    }

    public static void main(String[] args) {
        new Ventana();
        //Crear el JFrame
        Ventana Panel = new Ventana();
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(Panel.PanelMain);
        //Tamaño de el JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();//Ajusta el tamaño de la ventana
        frame.setVisible(true);





    }
}
