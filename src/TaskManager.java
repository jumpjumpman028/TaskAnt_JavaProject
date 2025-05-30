package src;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> taskList = new ArrayList<>();
    private final static TaskManager instance = new TaskManager();
    public static TaskManager getInstance() {
        return instance;
    }
    public void addTask(Task task){
        try{
            taskList.add(task);
        }catch(Exception e){
            System.out.println("addTask is Error!");
        }


    }
    public void updateStatus(Task task,Task.Status newStatus){
        task.setStatus(newStatus);
    }
    public List<Task> getTaskList(){
        return taskList;
    }
    public List<Task> getTasksByStatus(Task.Status status) {
        return taskList.stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());
    }
}