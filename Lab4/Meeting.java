import java.time.LocalTime;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private Priority priority;

    private final LocalTime EARLIEST_MEETING_HOUR = LocalTime.of(5, 0);

    public Meeting() {
    }

    public Meeting(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartTime(LocalTime start_time) {
        this.startTime = start_time;
    }

    public void setEndTime(LocalTime end_time) {
        this.endTime = end_time;
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

    @Override
    public String toString() {
        return "Meeting: " + description + ", start of meeting " + startTime + ", end of meeting " + endTime
                + ", priority: " + priority;
    }

}
