import java.time.LocalDate;

public final class House extends Building {

    private double landArea;

    public House(String street, String buildingNumber, String town, String postCode, double buildingArea, double price,
            LocalDate offerValidityDate, double landArea) {
        super(street, buildingNumber, town, postCode, buildingArea, price, offerValidityDate);
        this.landArea = landArea;
    }

    public double getLandArea() {
        return landArea;
    }

    @Override
    public String toString() {
        return super.toString() + ", Land Area: " + getLandArea() + ".";
    }

}
