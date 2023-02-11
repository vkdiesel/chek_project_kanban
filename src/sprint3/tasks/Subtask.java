package sprint3.tasks;
public class Subtask extends Task {
    private Integer numberOfEpic;
    public Subtask(String title, String description, String status, Integer numberOfEpic) {
        super(title, description, status);
        this.numberOfEpic=numberOfEpic;
    }
    public Subtask(String title, String description, Integer id, String status) { // id - id подзадачи
        super(title, description, id, status);
    }
    @Override
    public String toString() {
        return "Subtask{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", ID='" + getId() + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
    public Integer getNumberOfEpic() {
        return numberOfEpic;
    }
    public void setNumberOfEpic(Integer numberOfEpic) {
        this.numberOfEpic = numberOfEpic;
    }
    public void deleteNumberOfEpic() {
        numberOfEpic = null;
    }
}