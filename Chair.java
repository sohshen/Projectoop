/**
 * Represents a Chair, which is a type of Furniture.
 */
public class Chair extends Furniture {
    private boolean hasArmRest;

    public Chair(String name, String material, double price, boolean hasArmRest) {
        super(name, "Chair", material, price);
        this.hasArmRest = hasArmRest;
    }

    public boolean isHasArmRest() {
        return hasArmRest;
    }

    public void setHasArmRest(boolean hasArmRest) {
        this.hasArmRest = hasArmRest;
    }

    @Override
    public String getDescription() {
        return "Chair: " + getName() + ", Material: " + getMaterial() + ", Price: $" + getPrice() + ", Arm Rest: " + (hasArmRest ? "Yes" : "No");
    }
}

