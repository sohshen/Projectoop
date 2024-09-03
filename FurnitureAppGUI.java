import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A simple GUI application to manage furniture.
 */
public class FurnitureAppGUI {
    private JFrame frame;
    private FurnitureManager furnitureManager;

    public FurnitureAppGUI() {
        furnitureManager = new FurnitureManager();

        frame = new JFrame("Furniture Manager");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Furniture Name:");
        userLabel.setBounds(10, 20, 160, 25);
        panel.add(userLabel);

        JTextField furnitureNameText = new JTextField(20);
        furnitureNameText.setBounds(150, 20, 165, 25);
        panel.add(furnitureNameText);

        JLabel materialLabel = new JLabel("Material:");
        materialLabel.setBounds(10, 50, 160, 25);
        panel.add(materialLabel);

        // JComboBox for material selection
        String[] materials = {"Wood", "Metal", "Plastic", "Glass"};
        JComboBox<String> materialComboBox = new JComboBox<>(materials);
        materialComboBox.setBounds(150, 50, 165, 25);
        panel.add(materialComboBox);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(10, 80, 160, 25);
        panel.add(priceLabel);

        JTextField priceText = new JTextField(20);
        priceText.setBounds(150, 80, 165, 25);
        panel.add(priceText);

        JLabel armRestLabel = new JLabel("Has Arm Rest:");
        armRestLabel.setBounds(10, 110, 160, 25);
        panel.add(armRestLabel);

        // JComboBox for arm rest selection
        String[] armRestOptions = {"Yes", "No"};
        JComboBox<String> armRestComboBox = new JComboBox<>(armRestOptions);
        armRestComboBox.setBounds(150, 110, 165, 25);
        panel.add(armRestComboBox);

        JButton addButton = new JButton("Add Card");
        addButton.setBounds(10, 140, 150, 25);
        panel.add(addButton);

        JButton displayButton = new JButton("Display Furniture");
        displayButton.setBounds(180, 140, 150, 25);
        panel.add(displayButton);

        JTextArea displayArea = new JTextArea();
        displayArea.setBounds(10, 180, 320, 80);
        panel.add(displayArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = furnitureNameText.getText();
                String material = (String) materialComboBox.getSelectedItem();
                double price = Double.parseDouble(priceText.getText());
                boolean hasArmRest = "Yes".equals(armRestComboBox.getSelectedItem());

                Chair chair = new Chair(name, material, price, hasArmRest);
                furnitureManager.addFurniture(chair);

                // Save the chair details to a file
                saveFurnitureToFile(chair);

                JOptionPane.showMessageDialog(null, "Chair added successfully!");
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");
                for (Furniture furniture : furnitureManager.getFurnitureList()) {
                    displayArea.append(furniture.getDescription() + "\n");
                }
            }
        });
    }

    private void saveFurnitureToFile(Furniture furniture) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("furniture.txt", true))) {
            writer.write(furniture.getDescription());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving furniture to file: " + e.getMessage());
        }
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public static void main(String[] args) {
        FurnitureAppGUI app = new FurnitureAppGUI();
        app.setVisible(true);
    }
}
