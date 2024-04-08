import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        PrintInformation();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int choice;
        while (running) {
            choice = takeChoiceFromUser("""
                    1. Oblicz sume zakresu
                    2. Oblicz 2 do n""", scanner);

            if (choice == 1) {

                long startNum, endNum, sum;
                startNum = getInputFromUser("Podaj początkową liczbę zakresu: ", scanner);
                endNum = getInputFromUser("Podaj końcową liczbę zakresu: ", scanner);
                if (endNum < startNum) {
                    System.out.println("Liczba końcowa musi być większa od liczby początkowej");
                    continue;
                }
                sum = Calculations.calculateSum(startNum, endNum);
                System.out.println("Suma liczb z zakresu od " + startNum + " do " + endNum + " wynosi " + sum);
            } else if (choice == 2) {
                long number, power;
                number = getInputFromUser("Podaj liczbę: ", scanner);
                power = Calculations.calculatePower(number);
                System.out.println("Potęga 2 do " + number + " wynosi: " + power);
            } else {
                System.out.println("Nie ma takiego wyboru!");
            }
            running = askToContinue(scanner);

        }
        scanner.close();
        System.out.println("Program zakończył działanie.");
    }

    static int takeChoiceFromUser(String context, Scanner scanner) {
        System.out.println(context);
        return scanner.nextInt();
    }

    static void PrintInformation() {
        System.out.println("""
                -------------------------------------------------------

                Program oblicza sumę liczb naturalnych z zakresu liczb

                -------------------------------------------------------
                """);
    }

    static boolean askToContinue(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Czy chcesz kontynuować? (t/n)");
        String answer = scanner.nextLine();
        if (answer.equals("n")) {
            return false;
        }
        return true;
    }

    static long getInputFromUser(String context, Scanner scanner) {
        System.out.println(context);
        return scanner.nextLong();
    }

}
