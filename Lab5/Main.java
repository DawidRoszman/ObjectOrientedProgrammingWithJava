import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!\nThis program allows you to schedule your meetings during a week.");

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new Calendar();
        addMeetings(calendar);

        while (running) {
            displayMenu();
            int userChoice = getChoiceFromUser(scanner);
            switch (userChoice) {
                case 1 -> addMeeting(calendar, scanner);
                case 2 -> removeMeeting(calendar, scanner);
                case 3 -> displayMeetings(calendar, scanner);
                case 4 -> displayMeetingsWithGivenPriority(calendar, scanner);
                case 5 -> displayMeetingsAfterGivenTime(calendar, scanner);
                case 6 -> displayMeetingsBettweenGivenTimes(calendar, scanner);
                case 7 -> displayMeetingsAfterGivenTimeWithPriority(calendar, scanner);
                case 0 -> running = false;
                default -> System.out.println("Not such option");
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    static void displayMenu() {
        System.out.println("""
                ---------------------------------------------------------------------

                    Menu:
                    1. Add meeting
                    2. Delete meeting from given day
                    3. View meeting in a specific day
                    4. View meetings in a specific day with priority
                    5. View meetings in a specific day starting after given time
                    6. View meetings in a specific day starting between given time
                    7. View meetings in a specific day with priority after given time
                    0. Exit program

                -----------------------------------------------------------------------
                """);
    }

    static void addMeetings(Calendar calendar) {
        try {
            calendar.addMeeting(0, new Meeting("Meeting 1", LocalTime.of(12, 30), LocalTime.of(14, 30), Priority.HIGH));
            calendar.addMeeting(0,
                    new Meeting("Meeting 2", LocalTime.of(14, 30), LocalTime.of(16, 30), Priority.NORMAL));
            calendar.addMeeting(0,
                    new Meeting("Meeting 3", LocalTime.of(7, 30), LocalTime.of(10, 0), Priority.HIGHEST));
            calendar.addMeeting(0, new Meeting("Meeting 4", LocalTime.of(8, 30), LocalTime.of(9, 0), Priority.NORMAL));

            calendar.addMeeting(1, new Meeting("Meeting 1", LocalTime.of(12, 30), LocalTime.of(14, 30), Priority.HIGH));
            calendar.addMeeting(1,
                    new Meeting("Meeting 2", LocalTime.of(14, 30), LocalTime.of(16, 30), Priority.NORMAL));
            calendar.addMeeting(1,
                    new Meeting("Meeting 3", LocalTime.of(7, 30), LocalTime.of(10, 0), Priority.HIGHEST));
            calendar.addMeeting(1, new Meeting("Meeting 4", LocalTime.of(8, 30), LocalTime.of(9, 0), Priority.NORMAL));

            calendar.addMeeting(2, new Meeting("Meeting 1", LocalTime.of(12, 30), LocalTime.of(14, 30), Priority.HIGH));
            calendar.addMeeting(2,
                    new Meeting("Meeting 2", LocalTime.of(14, 30), LocalTime.of(16, 30), Priority.NORMAL));
            calendar.addMeeting(2,
                    new Meeting("Meeting 3", LocalTime.of(7, 30), LocalTime.of(10, 0), Priority.HIGHEST));
            calendar.addMeeting(2, new Meeting("Meeting 4", LocalTime.of(8, 30), LocalTime.of(9, 0), Priority.NORMAL));

        } catch (Exception e) {
            System.out.println(e);
        }
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

    static int getDayOfWeekFromUser(Scanner scanner) {
        System.out.println("""
                1. Monday
                2. Tuesday
                3. Wednesday
                4. Thursday
                5. Friday
                6. Saturday
                7. Sunday""");
        return getIntInputFromUser("Choose day: ", scanner) - 1;
    }

    static String getStringInputFromUser(String content, Scanner scanner) {
        System.out.print(content);
        return scanner.nextLine();
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

    static void addMeeting(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        String description = getStringInputFromUser("Enter description: ", scanner);
        LocalTime startTime = LocalTime.parse(getStringInputFromUser("Enter start time: ", scanner));
        LocalTime endTime = LocalTime.parse(getStringInputFromUser("Enter end time: ", scanner));
        Priority priority = getPriorityFromUser(scanner);

        Meeting newMeeting;
        try {
            newMeeting = new Meeting(description, startTime, endTime, priority);
        } catch (Exception e) {
            System.out.println(e);
            addMeeting(calendar, scanner);
            return;
        }
        int dayOfMeeting = getDayOfWeekFromUser(scanner);
        calendar.addMeeting(dayOfMeeting, newMeeting);

    }

    static void removeMeeting(Calendar calendar, Scanner scanner) {
        int day = displayMeetings(calendar, scanner);
        int meetingNumber = getIntInputFromUser("Enter number of meeting you want to delete: ", scanner);
        calendar.removeMeeting(day, calendar.getMeetingsFromDay(day, meeting -> true).get(meetingNumber - 1));
    }

    static int displayMeetings(Calendar calendar, Scanner scanner) {
        int day = getDayOfWeekFromUser(scanner);
        ArrayList<Meeting> meetingsInDay = calendar.getMeetingsFromDay(day, meeting -> true);
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
        return day;
    }

    static void displayMeetingsWithGivenPriority(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        Priority priority = getPriorityFromUser(scanner);
        int day = getDayOfWeekFromUser(scanner);

        ArrayList<Meeting> meetingsInDay = calendar.getMeetingsFromDay(day,
                meeting -> meeting.getPriority().equals(priority));
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
    }

    static void displayMeetingsAfterGivenTime(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        LocalTime startTime = LocalTime.parse(getStringInputFromUser("Enter start time: ", scanner));
        int day = getDayOfWeekFromUser(scanner);
        ArrayList<Meeting> meetingsInDay = calendar.getMeetingsFromDay(day,
                meeting -> meeting.getStartTime().compareTo(startTime) >= 0);
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
    }

    static void displayMeetingsAfterGivenTimeWithPriority(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        Priority priority = getPriorityFromUser(scanner);
        LocalTime startTime = LocalTime.parse(getStringInputFromUser("Enter start time: ", scanner));
        int day = getDayOfWeekFromUser(scanner);
        ArrayList<Meeting> meetingsInDay = calendar.getMeetingsFromDay(day,
                meeting -> meeting.getStartTime().compareTo(startTime) >= 0 && meeting.getPriority().equals(priority));
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
    }

    static void displayMeetingsBettweenGivenTimes(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        LocalTime startTime = LocalTime.parse(getStringInputFromUser("Enter start time: ", scanner));
        LocalTime endTime = LocalTime.parse(getStringInputFromUser("Enter end time: ", scanner));
        int day = getDayOfWeekFromUser(scanner);
        ArrayList<Meeting> meetingsInDay = calendar.getMeetingsFromDay(day,
                meeting -> meeting.getStartTime().compareTo(startTime) >= 0
                        && meeting.getEndTime().compareTo(endTime) <= 0);
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
    }
}
