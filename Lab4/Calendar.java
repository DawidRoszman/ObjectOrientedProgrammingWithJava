import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private final int CALENDAR_LENGTH = 7;
    private ArrayList<ArrayList<Meeting>> meetings;

    public Calendar() {
        meetings = new ArrayList<>();

        for (long i = 0; i < CALENDAR_LENGTH; i++) {
            meetings.add(new ArrayList<>());
        }
    }

    public void addMeeting(int dayNumber, Meeting meeting) {
        meetings.get(dayNumber).add(meeting);
    }

    public void removeMeeting(int dayNumber, Meeting meeting) {
        meetings.get(dayNumber).remove(meeting);
    }

    public ArrayList<Meeting> getMeetingsFromDay(int dayNumber) {
        return meetings.get(dayNumber);
    }

    public ArrayList<Meeting> getMeetingsFromDay(int dayNumber, Priority priority) {
        ArrayList<Meeting> matchingMeetings = new ArrayList<>();
        for (Meeting meeting : meetings.get(dayNumber)) {
            if (meeting.getPriority() == priority) {
                matchingMeetings.add(meeting);
            }
        }
        return matchingMeetings;
    }

    public ArrayList<Meeting> getMeetingsFromDay(int dayNumber, LocalTime startTime) {
        ArrayList<Meeting> matchingMeetings = new ArrayList<>();
        for (Meeting meeting : meetings.get(dayNumber)) {
            if (meeting.getStartTime().compareTo(startTime) >= 0) {
                matchingMeetings.add(meeting);
            }
        }
        return matchingMeetings;
    }
}
