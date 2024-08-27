import javax.swing.*;

public class ventana extends JFrame {
    private JList list1;
    private JList list2;
    private JPanel PanelMain;

    public ventana() {
        // Crea el JFrame

        ventana miventana = new ventana();
        JFrame frame = new JFrame();
        frame.setContentPane(miventana.PanelMain);
        frame.setTitle("Ventana de prueba");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ventana();
    }

}
