import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!\nThis program allows you to schedule your meeting during a week.");

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new Calendar();
        while (running) {
            displayMenu();
            int userChoice = getChoiceFromUser(scanner);
            switch (userChoice) {
                case 1 -> addMeeting(calendar, scanner);
                case 2 -> removeMeeting(calendar, scanner);
                case 3 -> displayMeetings(calendar, scanner);
                case 4 -> displayMeetingsWithGivenPriority(calendar, scanner);
                case 5 -> displayMeetingsAfterGivenTime(calendar, scanner);
                case 0 -> running = false;
                default -> System.out.println("Not such option");
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    static void displayMenu() {
        System.out.println("""
                Menu:
                1. Add meeting
                2. Delete meeting from given day
                3. View meeting in a specific day
                4. View meetings in a specific day with priority
                5. View meetings in a specific day starting after given time
                0. Exit program""");
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
        System.out.println(content);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Wrong input, try again!");
            scanner.nextLine();
            return getIntInputFromUser(content, scanner);
        }

    }

    static Priority getPriorityFromUser(Scanner scanner) {
        String priorityInput = getStringInputFromUser("Enter priority (normal/high/highest): ", scanner);
        Priority priority;

        if (priorityInput.equals("high")) {
            priority = Priority.HIGH;
        } else if (priorityInput.equals("highest")) {
            priority = Priority.HIGHEST;
        } else {
            priority = Priority.NORMAL;
        }
        return priority;
    }

    static String getStringInputFromUser(String content, Scanner scanner) {
        System.out.println(content);
        return scanner.nextLine();
    }

    static void addMeeting(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        String description = getStringInputFromUser("Enter description: ", scanner);
        LocalTime startTime = LocalTime.parse(getStringInputFromUser("Enter start time: ", scanner));
        LocalTime endTime = LocalTime.parse(getStringInputFromUser("Enter end time: ", scanner));
        Priority priority = getPriorityFromUser(scanner);

        Meeting newMeeting = new Meeting(description, startTime, endTime, priority);
        int dayOfMeeting = getIntInputFromUser("Enter day: ", scanner);
        calendar.addMeeting(dayOfMeeting, newMeeting);

    }

    static void removeMeeting(Calendar calendar, Scanner scanner) {
        int day = displayMeetings(calendar, scanner);
        int meetingNumber = getIntInputFromUser("Enter number of meeting you want to delete: ", scanner);
        calendar.removeMeeting(day, calendar.getMeetingsFromDay(day).get(meetingNumber - 1));
    }

    static int displayMeetings(Calendar calendar, Scanner scanner) {
        int day = getIntInputFromUser("Enter day: ", scanner);
        ArrayList<Meeting> meetingsInDay = calendar.getMeetingsFromDay(day);
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
        return day;
    }

    static void displayMeetingsWithGivenPriority(Calendar calendar, Scanner scanner) {
        int day = getIntInputFromUser("Enter day: ", scanner);
        Priority priority = getPriorityFromUser(scanner);

        ArrayList<Meeting> meetingsInDay = calendar.getMeetingsFromDay(day, priority);
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
    }

    static void displayMeetingsAfterGivenTime(Calendar calendar, Scanner scanner) {
        int day = getIntInputFromUser("Enter day: ", scanner);
        LocalTime startTime = LocalTime.parse(getStringInputFromUser("Enter start time: ", scanner));
        ArrayList<Meeting> meetingsInDay = calendar.getMeetingsFromDay(day, startTime);
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
    }

}
