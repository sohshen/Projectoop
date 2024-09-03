/**
 * Represents a general piece of furniture.
 */
public abstract class Furniture {
    private String name;
    private String type;
    private String material;
    private double price;

    public Furniture(String name, String type, String material, double price) {
        this.name = name;
        this.type = type;
        this.material = material;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    protected void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    public abstract String getDescription();
}
