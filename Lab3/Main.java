import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("""
                Welcome! This program allows you to add grades to a list,
                calculate average and find lowest and highest grade from the list.""");

        boolean running = true;
        GradeList gradeList = new GradeList();
        Scanner scanner = new Scanner(System.in);
        while (running) {
            displayMenu();
            int userChoice = getChoiceFromUser(scanner);
            switch (userChoice) {
                case 1 -> AddGrade(gradeList, scanner);
                case 2 -> CalculateAverage(gradeList);
                case 3 -> FindMax(gradeList);
                case 4 -> FindMin(gradeList);
                case 5 -> running = false;
                default -> System.out.println("Not such option");
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    static void displayMenu() {
        System.out.println("""
                Menu:
                1. Add grade
                2. Calculate average
                3. Find highest grade
                4. Find lowest grade
                5. Exit program""");
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

    static Double getGradeFromUser(Scanner scanner) {
        System.out.print("Enter grade: ");
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("This is not a correct input! Try again.");
            return getGradeFromUser(scanner);
        }
    }

    static double roundToHalf(Double d) {
        return Math.round(d * 2) / 2.0;
    }

    static void AddGrade(GradeList gradeList, Scanner scanner) {
        Double grade = getGradeFromUser(scanner);
        if (grade > 5 || grade < 2) {
            System.out.println("This is not a correct grade! Grade must be between 2 and 5");
            AddGrade(gradeList, scanner);
            return;
        }
        boolean success = gradeList.addGrade(roundToHalf(grade));
        if (success) {
            System.out.println("Grade was successfully added");
        } else {
            System.out.println("Error occured. Grade was not added");
        }
    }

    static void CalculateAverage(GradeList gradeList) {
        Double average;
        try {
            average = gradeList.calculateAverage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.printf("Average of grades in the list is: %.2f\n", average);
    }

    static void FindMax(GradeList gradeList) {
        Double max;
        try {
            max = gradeList.findMax();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.printf("Highest grade from the list is: %.1f\n", max);
    }

    static void FindMin(GradeList gradeList) {
        Double min;
        try {
            min = gradeList.findMin();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.printf("Lowest grade from the list is: %.1f\n", min);
    }
}
