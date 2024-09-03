/**
 * Represents a Table, which is a type of Furniture.
 */
public class Table extends Furniture {
    private int seatingCapacity;

    public Table(String name, String material, double price, int seatingCapacity) {
        super(name, "Table", material, price);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String getDescription() {
        return "Table: " + getName() + ", Material: " + getMaterial() + ", Price: $" + getPrice() + ", Seating Capacity: " + seatingCapacity;
    }
}
