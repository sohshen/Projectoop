import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of Furniture objects.
 */
public class FurnitureManager {
    private List<Furniture> furnitureList;

    public FurnitureManager() {
        furnitureList = new ArrayList<>();
    }

    public void addFurniture(Furniture furniture) {
        furnitureList.add(furniture);
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Furniture furniture : furnitureList) {
                writer.write(furniture.getDescription());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(String filename) throws IOException {
        furnitureList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Example of reading specific furniture data
                // Here you'd need to parse the data and instantiate the appropriate Furniture subclass
                System.out.println(line); // Displaying for now, should be replaced by actual parsing logic
            }
        }
    }

    public void displayAllFurniture() {
        for (Furniture furniture : furnitureList) {
            System.out.println(furniture.getDescription());
        }
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }
}
