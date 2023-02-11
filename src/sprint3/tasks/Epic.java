package sprint3.tasks;
import java.util.ArrayList;
public class Epic extends Task {
    private ArrayList<Integer> listOfSubtasks;

    public Epic (String title, String description, String status) {
        super(title, description, status);
        listOfSubtasks = new ArrayList<>();
    }
    public Epic (String title, String description, Integer id, String status) {
        super(title, description, id, status);
        listOfSubtasks = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Epic{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", ID='" + getId() + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
    public void addSubtasks(Integer subid) {
        listOfSubtasks.add(subid);
    }
    public void deleteListOfSubtasks() {
        listOfSubtasks.clear();
    }
    public ArrayList<Integer> getListOfSubtasks () {
        return listOfSubtasks;
    }

}
