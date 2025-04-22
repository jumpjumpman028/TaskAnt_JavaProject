package src;
import java.time.LocalDate;

public class Task {


    private String name;
    private String description;
    private String assignee;
    private Status status;
    private Type type;
    private LocalDate startDate;
    private LocalDate endDate;

    public Task(String name, String description, String assignee, Type type, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.description = description;
        this.assignee = assignee;
        this.status = Status.TODO;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Task(String name, String description, String assignee, Type type) {
        this.name = name;
        this.description = description;
        this.assignee = assignee;
        this.status = Status.TODO;
        this.type = type;
        this.startDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public enum Status {
        TODO, IN_PROGRESS, COMPLETED, LOCKED
    }

    public enum Type {
        GENERAL, NODE, BOSS
    }
}
