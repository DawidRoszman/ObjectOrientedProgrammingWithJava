import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!\nThis program allows you to schedule your meetings and tasks during a week.");

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new Calendar();
        addElements(calendar);

        while (running) {
            displayMenu();
            int userChoice = getChoiceFromUser(scanner);
            switch (userChoice) {
                case 1 -> addMeeting(calendar, scanner);
                case 2 -> addTask(calendar, scanner);
                case 3 -> removeMeeting(calendar, scanner);
                case 4 -> removeTask(calendar, scanner);
                case 5 -> displayMeetings(calendar, scanner);
                case 6 -> displayTasks(calendar, scanner);
                case 7 -> displayMeetingsWithGivenPriority(calendar, scanner);
                case 8 -> displayTasksWithGivenStatus(calendar, scanner);
                case 9 -> displayMeetingsStartingNotBeforeGivenTimeWithPriority(calendar, scanner);
                case 10 -> displayTasksEndingNotAfterGivenTimeWithStatus(calendar, scanner);
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
                    2. Add task
                    3. Delete meeting from given day
                    4. Delete task from given day
                    5. View meetings in a specific day
                    6. View tasks in a specific day
                    7. View meetings in a specific day with priority
                    8. View tasks in a specific day with status
                    9. View meetings in a specific day starting not before given time with a given priority
                    10. View tasks in a specific day ending not after given time with a given status
                    0. Exit program

                -----------------------------------------------------------------------
                """);
    }

    static void addElements(Calendar calendar) {
        try {
            calendar.addElement(0, new Meeting("Meeting 1", LocalTime.of(12, 30), LocalTime.of(14, 30), Priority.HIGH));
            calendar.addElement(0,
                    new Meeting("Meeting 2", LocalTime.of(14, 30), LocalTime.of(16, 30), Priority.NORMAL));
            calendar.addElement(0,
                    new Meeting("Meeting 3", LocalTime.of(7, 30), LocalTime.of(10, 0), Priority.HIGHEST));
            calendar.addElement(0, new Meeting("Meeting 4", LocalTime.of(8, 30), LocalTime.of(9, 0), Priority.NORMAL));

            calendar.addElement(1, new Meeting("Meeting 1", LocalTime.of(12, 30), LocalTime.of(14, 30), Priority.HIGH));
            calendar.addElement(1,
                    new Meeting("Meeting 2", LocalTime.of(14, 30), LocalTime.of(16, 30), Priority.NORMAL));
            calendar.addElement(1,
                    new Meeting("Meeting 3", LocalTime.of(7, 30), LocalTime.of(10, 0), Priority.HIGHEST));
            calendar.addElement(1, new Meeting("Meeting 4", LocalTime.of(8, 30), LocalTime.of(9, 0), Priority.NORMAL));

            calendar.addElement(2, new Meeting("Meeting 1", LocalTime.of(12, 30), LocalTime.of(14, 30), Priority.HIGH));
            calendar.addElement(2,
                    new Meeting("Meeting 2", LocalTime.of(14, 30), LocalTime.of(16, 30), Priority.NORMAL));
            calendar.addElement(2,
                    new Meeting("Meeting 3", LocalTime.of(7, 30), LocalTime.of(10, 0), Priority.HIGHEST));
            calendar.addElement(2, new Meeting("Meeting 4", LocalTime.of(8, 30), LocalTime.of(9, 0), Priority.NORMAL));
            // Add tasks
            calendar.addElement(0, new Task("Task 1", LocalTime.of(12, 30), LocalTime.of(14, 30), Status.PLANNED));
            calendar.addElement(0, new Task("Task 2", LocalTime.of(14, 30), LocalTime.of(16, 30), Status.PLANNED));
            calendar.addElement(0, new Task("Task 3", LocalTime.of(7, 30), LocalTime.of(10, 0), Status.IN_PROGRESS));
            calendar.addElement(0, new Task("Task 4", LocalTime.of(8, 30), LocalTime.of(9, 0), Status.DONE));
            calendar.addElement(0, new Task("Task 5", LocalTime.of(9, 30), LocalTime.of(11, 0), Status.IN_PROGRESS));
            calendar.addElement(0, new Task("Task 6", LocalTime.of(10, 30), LocalTime.of(12, 0), Status.DONE));
            calendar.addElement(0, new Task("Task 7", LocalTime.of(11, 30), LocalTime.of(13, 0), Status.PLANNED));
            calendar.addElement(0, new Task("Task 8", LocalTime.of(12, 30), LocalTime.of(14, 0), Status.IN_PROGRESS));
            calendar.addElement(0, new Task("Task 9", LocalTime.of(13, 30), LocalTime.of(15, 0), Status.DONE));
            calendar.addElement(0, new Task("Task 10", LocalTime.of(14, 30), LocalTime.of(16, 0), Status.PLANNED));

            calendar.addElement(1, new Task("Task 1", LocalTime.of(12, 30), LocalTime.of(14, 30), Status.PLANNED));
            calendar.addElement(1, new Task("Task 2", LocalTime.of(14, 30), LocalTime.of(16, 30), Status.CONFIRMED));

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

    static Status getStatusFromUser(Scanner scanner) {
        String statusInput = getStringInputFromUser("Enter status (planned, confirmed, in_progress, done): ", scanner);
        Status status;

        if (statusInput.equals("planned")) {
            status = Status.PLANNED;
        } else if (statusInput.equals("confirmed")) {
            status = Status.CONFIRMED;
        } else if (statusInput.equals("in_progress")) {
            status = Status.IN_PROGRESS;
        } else if (statusInput.equals("done")) {
            status = Status.DONE;
        } else {
            return getStatusFromUser(scanner);
        }
        return status;
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
            System.out.println(e.getMessage());
            addMeeting(calendar, scanner);
            return;
        }
        int dayOfMeeting = getDayOfWeekFromUser(scanner);
        calendar.addElement(dayOfMeeting, newMeeting);

    }

    static void addTask(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        String description = getStringInputFromUser("Enter description: ", scanner);
        LocalTime startTime = LocalTime.parse(getStringInputFromUser("Enter start time: ", scanner));
        LocalTime endTime = LocalTime.parse(getStringInputFromUser("Enter end time: ", scanner));
        Status status = getStatusFromUser(scanner);

        Task newTask;
        try {
            newTask = new Task(description, startTime, endTime, status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            addTask(calendar, scanner);
            return;
        }
        int dayOfTask = getDayOfWeekFromUser(scanner);
        calendar.addElement(dayOfTask, newTask);

    }

    static void removeMeeting(Calendar calendar, Scanner scanner) {
        int day = displayMeetings(calendar, scanner);
        int meetingNumber = getIntInputFromUser("Enter number of meeting you want to delete: ", scanner);
        calendar.removeElement(day,
                calendar.getElementsFromDay(day, meeting -> meeting instanceof Meeting).get(meetingNumber - 1));
    }

    static void removeTask(Calendar calendar, Scanner scanner) {
        int day = displayTasks(calendar, scanner);
        int taskNumber = getIntInputFromUser("Enter number of task you want to delete: ", scanner);
        calendar.removeElement(day, calendar.getElementsFromDay(day, task -> task instanceof Task).get(taskNumber - 1));
    }

    static int displayMeetings(Calendar calendar, Scanner scanner) {
        int day = getDayOfWeekFromUser(scanner);
        ArrayList<Element> meetingsInDay = calendar.getElementsFromDay(day, meeting -> meeting instanceof Meeting);
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
        return day;
    }

    static int displayTasks(Calendar calendar, Scanner scanner) {
        int day = getDayOfWeekFromUser(scanner);
        ArrayList<Element> tasksInDay = calendar.getElementsFromDay(day, task -> task instanceof Task);
        for (int i = 0; i < tasksInDay.size(); i++) {
            System.out.println(i + 1 + " " + tasksInDay.get(i));
        }
        return day;
    }

    static void displayMeetingsWithGivenPriority(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        Priority priority = getPriorityFromUser(scanner);
        int day = getDayOfWeekFromUser(scanner);

        ArrayList<Element> meetingsInDay = calendar.getElementsFromDay(day,
                meeting -> meeting instanceof Meeting && ((Meeting) meeting).getPriority().equals(priority));
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
    }

    static void displayTasksWithGivenStatus(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        Status status = getStatusFromUser(scanner);
        int day = getDayOfWeekFromUser(scanner);

        ArrayList<Element> tasksInDay = calendar.getElementsFromDay(day,
                task -> task instanceof Task && ((Task) task).getStatus().equals(status));
        for (int i = 0; i < tasksInDay.size(); i++) {
            System.out.println(i + 1 + " " + tasksInDay.get(i));
        }
    }

    static void displayMeetingsStartingNotBeforeGivenTimeWithPriority(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        Priority priority = getPriorityFromUser(scanner);
        LocalTime startTime = LocalTime.parse(getStringInputFromUser("Enter start time: ", scanner));
        int day = getDayOfWeekFromUser(scanner);
        ArrayList<Element> meetingsInDay = calendar.getElementsFromDay(day,
                meeting -> meeting instanceof Meeting && meeting.getStartTime().compareTo(startTime) >= 0
                        && ((Meeting) meeting).getPriority().equals(priority));
        for (int i = 0; i < meetingsInDay.size(); i++) {
            System.out.println(i + 1 + " " + meetingsInDay.get(i));
        }
    }

    static void displayTasksEndingNotAfterGivenTimeWithStatus(Calendar calendar, Scanner scanner) {
        scanner.nextLine();
        Status status = getStatusFromUser(scanner);
        LocalTime endTime = LocalTime.parse(getStringInputFromUser("Enter end time: ", scanner));
        int day = getDayOfWeekFromUser(scanner);
        ArrayList<Element> tasksInDay = calendar.getElementsFromDay(day,
                task -> task instanceof Task && task.getEndTime().compareTo(endTime) <= 0
                        && ((Task) task).getStatus().equals(status));
        for (int i = 0; i < tasksInDay.size(); i++) {
            System.out.println(i + 1 + " " + tasksInDay.get(i));
        }
    }

}
