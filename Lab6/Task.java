import java.time.LocalTime;

public final class Task extends Element {
    private Status status;

    public Task(String description, LocalTime startTime, LocalTime endTime, Status status) throws Exception {
        super(description, startTime, endTime);
        this.status = status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Task: " + getDescription() + ", start of task " + getStartTime() + ", end of task "
                + getEndTime()
                + ", status: " + getStatus();
    }

}
