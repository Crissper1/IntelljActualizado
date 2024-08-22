
package org.example;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class textfild extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (isValidInput(fb.getDocument().getText(0, offset) + string)) { // Verificar antes de insertar
            super.insertString(fb, offset, string, attr);
        } else {
            showError("El valor debe estar entre 1 y 12");
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (isValidInput(fb.getDocument().getText(0, offset) + text + fb.getDocument().getText(offset + length, fb.getDocument().getLength() - offset - length))) { // Verificar antes de reemplazar
            super.replace(fb, offset, length, text, attrs);
        } else {
            showError("El valor debe estar entre 1 y 12");
        }
    }

    private boolean isValidInput(String text) {
        try {
            if (text.isEmpty()) {
                return true; // Permitir entrada vacía
            }
            int number = Integer.parseInt(text);
            return number >= 1 && number <= 12;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
