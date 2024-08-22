package org.example;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    public static class ventana {

        private JPanel frame;
        private JList list1;

        public class JListWithScrollPane {

            public static void main(String[] args) {
                // Crear el JFrame

                JFrame frame = new JFrame("JList con JScrollPane");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 200);

                // Crear el modelo para el JList
                DefaultListModel<String> listModel = new DefaultListModel<>();
                listModel.addElement("Elemento 1");
                listModel.addElement("Elemento 2");
                listModel.addElement("Elemento 3");
                listModel.addElement("Elemento 4");
                listModel.addElement("Elemento 5");
                listModel.addElement("Elemento 6");
                listModel.addElement("Elemento 7");
                listModel.addElement("Elemento 8");
                listModel.addElement("Elemento 9");
                listModel.addElement("Elemento 10");

                // Crear el JList y agregarle el modelo
                JList<String> jList = new JList<>(listModel);

                // Crear el JScrollPane y agregar el JList
                JScrollPane scrollPane = new JScrollPane(jList);

                // Agregar el JScrollPane al JFrame
                frame.add(scrollPane, BorderLayout.CENTER);

                // Hacer visible el JFrame
                frame.setVisible(true);
            }
        }

    }
}