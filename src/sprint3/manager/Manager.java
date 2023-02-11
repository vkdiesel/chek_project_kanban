package sprint3.manager;
import sprint3.tasks.Epic;
import sprint3.tasks.Subtask;
import sprint3.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private final HashMap<Integer, Task> tasks;
    private final HashMap<Integer, Subtask> subtasks;
    private final HashMap<Integer, Epic> epics;
    private int count = 0; // исходное значение счетчика для расчета ID

    public Manager() {
        tasks = new HashMap<>();
        epics = new HashMap<>();
        subtasks = new HashMap<>();
    }

    // служебный метод - счетчик для расчета сквозного ID
    private int newCount () {
        return ++count;
    }
    // сохранение подзадачи
    public void createSubtask(Subtask subtask) {
        subtask.setStatus("NEW"); // при создании НОВОГО присваиваем NEW
        subtask.setId(newCount());
        subtasks.put(subtask.getId(), subtask);
        epics.get(subtask.getNumberOfEpic()).addSubtasks(subtask.getId());
        checkAndRenameStatus(subtask.getNumberOfEpic());
    }
    // сохранение эпика
    public void createEpic(Epic epic) {
        epic.setStatus("NEW"); // при создании НОВОГО присваиваем NEW
        epic.setId(newCount());
        epics.put(epic.getId(), epic);
        checkAndRenameStatus(epic.getId());
    }
    //Сохранение одиночной задачи
    public void createTask(Task task) {
        task.setStatus("NEW"); // при создании НОВОГО присваиваем NEW
        task.setId(newCount());
        tasks.put(task.getId(), task);
    }
    //вывод списка Задач
    public ArrayList<Task> getListTask() {
        return new ArrayList<>(tasks.values());
    }
    //вывод списка Эпиков
    public ArrayList<Epic> getListEpic() {
        return new ArrayList<>(epics.values());
    }
    //вывод списка Подзадач
    public ArrayList<Subtask> getListSubtask() {
        return new ArrayList<>(subtasks.values());
    }
    // удаление списка Задач
    public void clearTask() {
        tasks.clear();
    }
    // удаление списка Эпиков
    public void clearEpic() {
        epics.clear();
        subtasks.clear(); //удаляем Сабтаски, т.к. без Эпиков не может быть Сабтасков
    }
    // удаление списка Подзадач
    public void clearSubtask() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.deleteListOfSubtasks();
            checkAndRenameStatus(epic.getId());
        }
    }
    // возвращает Задачу по номеру ID
    public Task getTaskById (Integer id) {
        return tasks.get(id);
    }
    // возвращает Эпик по номеру ID
    public Epic getEpicById (Integer id) {
        return epics.get(id);
    }
    // возвращает Подзадачу по номеру ID
    public Subtask getSubtaskById (Integer id) {
        return subtasks.get(id);
    }
    // обновление Задачи
    public void updateTask(Task task) {
        tasks.replace(task.getId(), task);
    }
    // обновление Эпика
    public void updateEpic(Epic epic) {
        for (Integer count : epics.get(epic.getId()).getListOfSubtasks()) {
            epic.addSubtasks(count);
        }
        epics.replace(epic.getId(), epic);
        checkAndRenameStatus(epic.getId());
    }
    // обновление Подзадачи
    public void updateSubtask(Subtask subtask) {
        subtask.setNumberOfEpic(subtasks.get(subtask.getId()).getNumberOfEpic());
        subtasks.replace(subtask.getId(), subtask);
        checkAndRenameStatus(subtask.getNumberOfEpic());
    }
    //удаление Задачи по номеру ID
    public void removeTaskById(Integer id) {
        tasks.remove(id);
    }
    // удаление Эпика по номеру ID
    public void removeEpicById(Integer id) {
        for (Integer count : epics.get(id).getListOfSubtasks()){
            subtasks.remove(count);
        }
        epics.remove(id);
    }
    // удаление Подзадачи по номеру ID
    public void removeSubtaskById (Integer id) {
        returnEpic(id).getListOfSubtasks().remove(id);
        checkAndRenameStatus(subtasks.get(id).getNumberOfEpic());
        subtasks.remove(id);
    }
    // возвращает подзадачи, которые есть в эпике (ID Эпика)
    public ArrayList<Subtask> returnSubtask(Integer epicId) {
        ArrayList<Subtask> result = new ArrayList<>();
        for (Integer count : epics.get(epicId).getListOfSubtasks()) {
            result.add(subtasks.get(count));
        }
        return result;
    }
    //служебный метод: возращает эпик, к которому относится подзадача (ID Подзадачи)
    private Epic returnEpic(Integer subId) {
        return epics.get(subtasks.get(subId).getNumberOfEpic());
    }
    // служебный метод для проверки и перезаписи статуса эпика (ID эпика)
    private void checkAndRenameStatus(Integer epicId) {
        if (returnSubtask(epicId).size() == 0) {
            epics.get(epicId).setStatus("NEW");
        } else {
            for (Subtask subtask : returnSubtask(epicId)) {
                if (!returnSubtask(epicId).get(0).getStatus().equals(subtask.getStatus())) {
                    epics.get(epicId).setStatus("IN_PROGRESS");
                    break; // первое несовпадение в статусах - заканчиваем перебор и ставим IN_PROGRESS
                }
                epics.get(epicId).setStatus(subtask.getStatus());
            }
        }
        epics.replace(epicId, epics.get(epicId));
    }
}