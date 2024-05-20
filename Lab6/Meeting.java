import java.time.LocalTime;

public final class Meeting extends Element {
    private Priority priority;

    public Meeting(String description, LocalTime startTime, LocalTime endTime, Priority priority) throws Exception {
        super(description, startTime, endTime);
        this.priority = priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return this.priority;
    }

    @Override
    public String toString() {
        return "Meeting: " + getDescription() + ", start of meeting " + getStartTime() + ", end of meeting "
                + getEndTime()
                + ", priority: " + getPriority();
    }

}
