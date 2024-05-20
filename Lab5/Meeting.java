import java.time.LocalTime;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private Priority priority;

    public static final LocalTime EARLIEST_MEETING_HOUR = LocalTime.of(5, 0);

    public Meeting() {
    }

    public Meeting(String description, LocalTime startTime, LocalTime endTime, Priority priority) throws Exception {
        if (startTime.compareTo(EARLIEST_MEETING_HOUR) < 0) {
            throw new Exception("Meeting cannot be this early");
        }
        if (endTime.compareTo(startTime) < 0) {
            throw new Exception("Start time must be before end time");
        }

        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartTime(LocalTime startTime) throws Exception {
        if (startTime.compareTo(EARLIEST_MEETING_HOUR) < 0) {
            throw new Exception("Meeting cannot be this early");
        }
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Meeting: " + description + ", start of meeting " + startTime + ", end of meeting " + endTime
                + ", priority: " + priority;
    }

}
