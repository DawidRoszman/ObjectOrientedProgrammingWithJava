import java.time.LocalDate;

public final class Flat extends Building {
    private String flatNumber;
    private int floorNumber;

    public Flat(String street, String buildingNumber, String town, String postCode, double buildingArea, double price,
            LocalDate offerValidityDate, String flatNumber, int floorNumber) {
        super(street, buildingNumber, town, postCode, buildingArea, price, offerValidityDate);
        this.flatNumber = flatNumber;
        this.floorNumber = floorNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", Flat Number: " + getFlatNumber() + ", Floor Number: " + getFloorNumber() + ".";
    }

}
