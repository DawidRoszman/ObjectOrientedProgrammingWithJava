import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        welcomeUser();

        Scanner scanner = new Scanner(System.in);
        Cylinder cylinder = new Cylinder();
        boolean running = true;

        while (running) {
            displayOptions();
            int userChoice = getIntInputFromUser("", scanner);
            switch (userChoice) {
                case 1 -> displayCylinderValues(cylinder);
                case 2 -> setValuesOfCylinder(cylinder, scanner);
                case 3 -> displayArea(cylinder);
                case 4 -> displayVolume(cylinder);
                case 5 -> running = false;
                default -> System.out.println("No such option, try again!");
            }
        }
        System.out.println("Goodbye! Have a nice day!");
        scanner.close();
    }

    static void welcomeUser() {
        System.out.println("""
                Welcome to the program!
                This program can calculate area and volume of a cylinder""");
    }

    static void displayOptions() {
        System.out.println("""
                Choose one:
                1. Display current values of cylinder
                2. Set values of cylinder
                3. Calculate areas of the cylinder
                4. Calculate volume of the cylinder
                5. Exit the program""");
    }

    static void displayCylinderValues(Cylinder cylinder) {
        System.out.println("Radius: " + cylinder.getRadius()
                + "\nHeight: " + cylinder.getHeight());
    }

    static int getIntInputFromUser(String content, Scanner scanner) {
        System.out.println(content);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Wrong input, try again!");
            scanner.nextLine();
            return getIntInputFromUser(content, scanner);
        }

    }

    static float getFloatInputFromUser(String content, Scanner scanner) {
        System.out.println(content);
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input, try again!");
            scanner.nextLine();
            return getFloatInputFromUser(content, scanner);
        }
    }

    static void setValuesOfCylinder(Cylinder cylinder, Scanner scanner) {
        float radius = getFloatInputFromUser("Enter a radius of a cylinder", scanner);
        float height = getFloatInputFromUser("Enter a height of a cylinder", scanner);
        try {
            cylinder.setRadius(radius);
            cylinder.setHeight(height);
        } catch (ArithmeticException e) {
            System.err.println(e);
            setValuesOfCylinder(cylinder, scanner);
            return;
        }

    }

    static void displayArea(Cylinder cylinder) {
        double baseSurfaceArea = cylinder.calculateBaseSurfaceArea();
        double lateralSurfaceArea = cylinder.calculateLateralSurfaceArea();
        double totalSurfaceArea = cylinder.calculateTotalSurfaceArea();
        String response = String.format("""
                Base surface area: %.2f
                Lateral surface area: %.2f
                Total surface area: %.2f""", baseSurfaceArea, lateralSurfaceArea, totalSurfaceArea);
        System.out.println(response);
    }

    static void displayVolume(Cylinder cylinder) {
        double volume = cylinder.calculateVolume();
        System.out.printf("Volume: %.2f\n", volume);

    }

}
