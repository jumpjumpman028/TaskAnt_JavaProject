package src;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.List;
public class Task {


    private String name;
    private String description;
    private String assignee;
    private Status status;
    private Type type;
    private List<DayOfWeek> recurringDays; //任務每周執行時間(若有)
    private LocalDate startDate; //開始日期
    private LocalDate endDate;  //結束日期
    private LocalTime startTime;    //開始執行時間
    private LocalTime endTime;  //結束執行時間

    public Task(String name, String description, String assignee, Type type, LocalTime startTime, LocalTime endTime,List<DayOfWeek> recurringDays) {
        //制式化任務範例
        this.name = name;
        this.description = description;
        this.assignee = assignee;
        this.status = Status.TODO;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.recurringDays = recurringDays;
    }
    public Task(String name, String description, String assignee, Type type,LocalTime startTime, LocalTime endTime) {
        //每天重複任務範例
        this.name = name;
        this.description = description;
        this.assignee = assignee;
        this.status = Status.TODO;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.recurringDays = List.of(DayOfWeek.MONDAY,DayOfWeek.TUESDAY,DayOfWeek.WEDNESDAY,DayOfWeek.THURSDAY,DayOfWeek.FRIDAY,DayOfWeek.SATURDAY,DayOfWeek.SUNDAY);

    }
    public Task(String name, String description, String assignee, Type type,LocalDate startDate) {
        //一次性任務範例
        this.name = name;
        this.description = description;
        this.assignee = assignee;
        this.status = Status.IN_PROGRESS;
        this.type = type;
        this.startDate = startDate;
        this.startTime = null;
        this.endTime = null;
        this.recurringDays = null;

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
        if(status == Status.COMPLETED && this.status == Status.IN_PROGRESS){
            setEndDate( LocalDate.now());
        }
        if(status == Status.IN_PROGRESS && this.status == Status.TODO){
            setStartDate(LocalDate.now());
        }
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public List<DayOfWeek> getRecurringDays() {
        return recurringDays;
    }

    public void setRecurringDays(List<DayOfWeek> recurringDays) {
        this.recurringDays = recurringDays;
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }
    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }

    public void setStartTime(LocalTime startTime) {
        if(startTime.isAfter(endTime)){
            DeBugConsole.log("setStartTime is Error!,startTime is after endTime");
        }
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        if(endTime.isBefore(startTime)){
            DeBugConsole.log("setEndTime is Error!,endTime is before startTime");
        }
        this.endTime = endTime;
    }

    public enum Status {
        TODO, IN_PROGRESS, COMPLETED, LOCKED
    }

    public enum Type {
        GENERAL, NODE, BOSS
    }
}
