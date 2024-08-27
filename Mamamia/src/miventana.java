import javax.swing.*;

public class miventana {

    private JList list1;
    private JPanel PanelMain;

    public miventana() {

        JFrame frame = new JFrame("miventana");
        frame.setContentPane(this.PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new miventana();
    }



}
