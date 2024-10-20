import javax.swing.*;

public class WindowManager {

    private static WindowManager instance = null;
    private JFrame currentWindow;

    private WindowManager() {
        // Constructor privado para prevenir instanciación
    }

    // Método para obtener la instancia única de WindowManager
    public static WindowManager getInstance() {
        if (instance == null) {
            instance = new WindowManager();
        }
        return instance;
    }

    public void openWindow(JFrame newWindow) {
        if (currentWindow != null) {
            currentWindow.dispose();
        }
        currentWindow = newWindow;
        currentWindow.setVisible(true);
        currentWindow.pack();
    }

    public void closeCurrentWindow() {
        if (currentWindow != null) {
            currentWindow.dispose();
            currentWindow = null;
        }
    }
}
