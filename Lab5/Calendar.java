import java.util.ArrayList;
import java.util.function.Predicate;

public class Calendar {
    public static final int CALENDAR_LENGTH = 7;
    private ArrayList<ArrayList<Meeting>> meetings;

    public Calendar() {
        meetings = new ArrayList<>();

        for (int i = 0; i < CALENDAR_LENGTH; i++) {
            meetings.add(new ArrayList<>());
        }
    }

    public void addMeeting(int dayNumber, Meeting meeting) {
        meetings.get(dayNumber).add(meeting);
    }

    public void removeMeeting(int dayNumber, Meeting meeting) {
        meetings.get(dayNumber).remove(meeting);
    }

    public ArrayList<Meeting> getMeetingsFromDay(int dayNumber, Predicate<Meeting> checker) {
        ArrayList<Meeting> matchingMeeting = new ArrayList<>();
        for (Meeting meeting : meetings.get(dayNumber)) {
            if (checker.test(meeting)) {
                matchingMeeting.add(meeting);
            }
        }
        return matchingMeeting;
    }
}
