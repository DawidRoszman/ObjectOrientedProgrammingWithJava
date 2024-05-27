import java.time.LocalDate;

public sealed abstract class Building permits House, Flat {
    private String street;
    private String buildingNumber;
    private String town;
    private String postCode;
    private double buildingArea;
    private double price;
    private LocalDate offerValidityDate;

    public Building(String street, String buildingNumber, String town, String postCode, double buildingArea,
            double price,
            LocalDate offerValidityDate) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.town = town;
        this.postCode = postCode;
        this.buildingArea = buildingArea;
        this.price = price;
        this.offerValidityDate = offerValidityDate;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getTown() {
        return town;
    }

    public String getPostCode() {
        return postCode;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getOfferValidityDate() {
        return offerValidityDate;
    }

    public double getBuildingArea() {
        return buildingArea;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setBuildingArea(double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOfferValidityDate(LocalDate offerValidityDate) {
        this.offerValidityDate = offerValidityDate;
    }

    public boolean isValidOffer() {
        return offerValidityDate.compareTo(LocalDate.now()) >= 0;
    }

    @Override
    public String toString() {
        return "Town: " + getTown() + ", Street: " + getStreet() + ", Building number: " + getBuildingArea()
                + ", Post Code: " + getPostCode() + ", Price: " + getPrice()
                + ", Offer Validity Date: " + getOfferValidityDate() + ", Building Area: " + getBuildingArea()
                + ", Price: " + getPrice();
    }

}
