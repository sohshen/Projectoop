import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FurnitureAppGUI app = new FurnitureAppGUI();
            app.setVisible(true);
        });
    }
}

