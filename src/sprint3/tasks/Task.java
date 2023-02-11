package sprint3.tasks;
public class Task {
    private Integer id;
    private String title;
    private String description;
    private String status;
    public Task (String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }
    public Task (String title, String description, Integer id, String status) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Task{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", ID='" + getId() + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

