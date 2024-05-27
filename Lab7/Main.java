import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!\nThis program allows you to view and filter house and flat offers.");

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        Offers offers = new Offers();
        generateFlatOffers(offers);
        generateHouseOffers(offers);

        while (running) {
            displayMenu();
            int userChoice = getChoiceFromUser(scanner);
            switch (userChoice) {
                case 1 -> AddHouseOffer(offers, scanner);
                case 2 -> AddFlatOffer(offers, scanner);
                case 3 -> ViewValidHouseOffers(offers);
                case 4 -> ViewvValidFlatOffers(offers);
                case 5 -> ViewValidHouseOffersTownAndAreaFilter(offers, scanner);
                case 6 -> ViewValidFlatOffersWithTownPriceAndFloorFilter(offers, scanner);
                case 0 -> running = false;
                default -> System.out.println("Not such option");
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    static void AddHouseOffer(Offers offers, Scanner scanner) {
        String street = getStringInputFromUser("Enter street name: ", scanner);
        String buildingNumber = getStringInputFromUser("Enter building number: ", scanner);
        String town = getStringInputFromUser("Enter town name: ", scanner);
        String postCode = getStringInputFromUser("Enter post code: ", scanner);
        double buildingArea = getDoubleInputFromUser("Enter area of the building: ", scanner);
        double price = getDoubleInputFromUser("Enter price: ", scanner);
        double landArea = getDoubleInputFromUser("Enter land area: ", scanner);
        LocalDate offerValidityDate = LocalDate.parse(getStringInputFromUser("Enter offer validity date: ", scanner));

        House house = new House(street, buildingNumber, town, postCode, buildingArea, price, offerValidityDate,
                landArea);
        offers.add(house);
    }

    static void AddFlatOffer(Offers offers, Scanner scanner) {
        String street = getStringInputFromUser("Enter street name: ", scanner);
        String buildingNumber = getStringInputFromUser("Enter building number: ", scanner);
        String flatNumber = getStringInputFromUser("Enter flat number: ", scanner);
        String town = getStringInputFromUser("Enter town name: ", scanner);
        String postCode = getStringInputFromUser("Enter post code: ", scanner);
        double buildingArea = getDoubleInputFromUser("Enter area of the building: ", scanner);
        int floorNumber = getIntInputFromUser("Enter floor number: ", scanner);
        double price = getDoubleInputFromUser("Enter price: ", scanner);
        LocalDate offerValidityDate = LocalDate.parse(getStringInputFromUser("Enter offer validity date: ", scanner));

        Flat flat = new Flat(street, buildingNumber, town, postCode, buildingArea, price, offerValidityDate, flatNumber,
                floorNumber);
        offers.add(flat);
    }

    static void ViewValidHouseOffers(Offers offers) {
        ArrayList<Building> validBuildingOffers = offers.filter(building -> building instanceof House
                && building.isValidOffer());
        for (Building building : validBuildingOffers) {
            System.out.println(building);
        }

    }

    static void ViewvValidFlatOffers(Offers offers) {
        ArrayList<Building> validBuildingOffers = offers.filter(building -> building instanceof Flat
                && building.isValidOffer());
        for (Building building : validBuildingOffers) {
            System.out.println(building);
        }
    }

    static void ViewValidHouseOffersTownAndAreaFilter(Offers offers, Scanner scanner) {
        scanner.nextLine();
        String town = getStringInputFromUser("Enter town name: ", scanner);
        double buildingArea = getDoubleInputFromUser("Enter building area: ", scanner);
        ArrayList<Building> validBuildingOffers = offers.filter(building -> building instanceof House
                && building.isValidOffer() && building.getTown().equals(town)
                && building.getBuildingArea() >= buildingArea);
        for (Building building : validBuildingOffers) {
            System.out.println(building);
        }
    }

    static void ViewValidFlatOffersWithTownPriceAndFloorFilter(Offers offers, Scanner scanner) {
        scanner.nextLine();
        String town = getStringInputFromUser("Enter town name: ", scanner);
        double price = getDoubleInputFromUser("Enter price: ", scanner);
        int floorNumber = getIntInputFromUser("Enter floor number: ", scanner);
        ArrayList<Building> validBuildingOffers = offers.filter(building -> building instanceof Flat
                && building.isValidOffer() && building.getTown().equals(town)
                && building.getPrice() <= price
                && ((Flat) building).getFloorNumber() >= floorNumber);
        for (Building building : validBuildingOffers) {
            System.out.println(building);
        }
    }

    static void displayMenu() {
        System.out.println(
                """
                        ---------------------------------------------------------------------

                            Menu:
                            1. Add house offer
                            2. Add flat offer
                            3. View all valid house offers
                            4. View all valid flat offers
                            5. View all valid house offers in given town with area no smaller than given input
                            6. View all valid flat offers in given town not more expensive than given input and on floor equal or higher
                            0. Exit program

                        -----------------------------------------------------------------------
                        """);
    }

    static void generateHouseOffers(Offers offers) {
        offers.add(new House("Street1", "12", "Town1", "201-143", 120.0, 1000.0, LocalDate.parse("2024-05-29"),
                200.0));
        offers.add(new House("Street2", "13", "Town1", "201-144", 130.0, 2000.0, LocalDate.parse("2023-12-12"),
                210.0));
        offers.add(new House("Street3", "14", "Town1", "201-145", 140.0, 3000.0, LocalDate.parse("2024-09-12"),
                220.0));
        offers.add(new House("Street4", "15", "Town2", "201-146", 150.0, 4000.0, LocalDate.parse("2024-12-12"),
                230.0));
        offers.add(new House("Street5", "16", "Town2", "201-147", 160.0, 5000.0, LocalDate.parse("2024-08-12"),
                240.0));
        offers.add(new House("Street6", "17", "Town2", "201-148", 170.0, 6000.0, LocalDate.parse("2024-07-12"),
                250.0));
    }

    static void generateFlatOffers(Offers offers) {
        offers.add(new Flat("Street1", "12", "Town1", "201-143", 120.0, 100.0, LocalDate.parse("2024-03-12"),
                "1", 1));
        offers.add(new Flat("Street2", "13", "Town1", "201-144", 130.0, 200.0, LocalDate.parse("2024-10-12"),
                "2", 2));
        offers.add(new Flat("Street3", "14", "Town2", "201-145", 140.0, 300.0, LocalDate.parse("2024-11-12"),
                "8", 8));
        offers.add(new Flat("Street4", "14", "Town2", "201-145", 140.0, 400.0, LocalDate.parse("2024-09-12"),
                "3", 3));
        offers.add(new Flat("Street5", "15", "Town2", "201-146", 150.0, 500.0, LocalDate.parse("2024-08-04"),
                "4", 4));
        offers.add(new Flat("Street6", "16", "Town2", "201-147", 160.0, 600.0, LocalDate.parse("2024-05-05"),
                "5", 5));
        offers.add(new Flat("Street7", "17", "Town3", "201-148", 170.0, 700.0, LocalDate.parse("2024-06-06"),
                "6", 6));
        offers.add(new Flat("Street8", "18", "Town3", "201-149", 180.0, 800.0, LocalDate.parse("2024-07-07"),
                "7", 7));

    }

    static int getChoiceFromUser(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("This is not a correct input! Try again.");
            return getChoiceFromUser(scanner);
        }
    }

    static int getIntInputFromUser(String content, Scanner scanner) {
        System.out.print(content);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Wrong input, try again!");
            scanner.nextLine();
            return getIntInputFromUser(content, scanner);
        }

    }

    static double getDoubleInputFromUser(String content, Scanner scanner) {
        System.out.print(content);
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.err.println("Wrong input, try again!");
            scanner.nextLine();
            return getIntInputFromUser(content, scanner);
        }

    }

    static String getStringInputFromUser(String content, Scanner scanner) {
        System.out.print(content);
        return scanner.next();
    }

}
