import sprint3.manager.Manager;
import sprint3.tasks.Task;
import sprint3.tasks.Epic;
import sprint3.tasks.Subtask;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

                            /* ******* Тестирование и отладка *******   */
        //Исходные данные
        manager.createTask(new Task("Одиночная задача 1", "Описание задачи 1", "NEW"));
        manager.createTask(new Task("Одиночная задача 2", "Описание задачи 2", "NEW"));
        manager.createEpic(new Epic("Эпик 1","Новый эпик 1", "NEW"));
        manager.createEpic(new Epic("Эпик 2","Новый эпик 2", "IN_PROGRESS"));
        manager.createSubtask(new Subtask("ПЗ 1.1","НПЗ 1.1", "IN_PROGRESS", 3));
        manager.createSubtask(new Subtask("ПЗ 1.2","НПЗ 1.2", "NEW", 3));
        manager.createSubtask(new Subtask("ПЗ 1.3","НПЗ 1.3", "DONE", 3));
        manager.createSubtask(new Subtask("ПЗ 1.4","НПЗ 1.4", "DONE",3));
        manager.createSubtask(new Subtask("ПЗ 2.1","НПЗ 2.1", "NEW",4));
        manager.createSubtask(new Subtask("ПЗ 2.2","НПЗ 2.2", "NEW",4));






                     /* ***Проверка действий*** */

        //manager.getListTask(); // получить список всех Задач
        //manager.getListEpic(); // получить список всех Эпиков
        //manager.getListSubtask(); // получить список всех Подзадач

        //manager.clearTask(); // удалить все Задачи
        //manager.clearEpic(); // удалить все Эпики
        //manager.clearSubtask(); //удалить все Подзадачи

        //manager.getTaskById(1); // получить Задачу по номеру ID
        //manager.getEpicById(3); // получить Эпик по номеру ID
        //manager.getSubtaskById(4); // получить Подзадачу по номеру ID

        //manager.updateTask(new Task("ОДИНОЧНАЯ ЗАДАЧА 1", "ОПИСАНИЕ ЗАДАЧИ 1", 1, "IN_PROGRESS")); // внести изменения в Задачу
        //manager.updateTask(new Task("ОДИНОЧНАЯ ЗАДАЧА 2", "ОПИСАНИЕ ЗАДАЧИ 2", 2, "DONE")); // внести изменения в Задачу
        //manager.updateEpic(new Epic("ЭПИК 1","НОВЫЙ ЭПИК 1", 3, "IN_PROGRESS")); // внести изменения в Эпик
        //manager.updateEpic(new Epic("ЭПИК 2","НОВЫЙ ЭПИК 2", 4, "DONE")); // внести изменения в Эпик
        //manager.updateSubtask(new Subtask("ПЗ 1.1", "НОВОЕ ОПИСАНИЕ ПЗ 1.1", 5, "DONE")); // внести изменения в Подзадачу
        //manager.updateSubtask(new Subtask("ПЗ 1.2", "НОВОЕ ОПИСАНИЕ ПЗ 1.2", 6, "IN_PROGRESS")); // внести изменения в Подзадачу
        //manager.updateSubtask(new Subtask("ПЗ 1.3", "НОВОЕ ОПИСАНИЕ ПЗ 1.3", 7, "DONE")); // внести изменения в Подзадачу
        //manager.updateSubtask(new Subtask("ПЗ 1.4", "НОВОЕ ОПИСАНИЕ ПЗ 1.4", 8, "DONE")); // внести изменения в Подзадачу
        //manager.updateSubtask(new Subtask("ПЗ 2.1", "НОВОЕ ОПИСАНИЕ ПЗ 2.1", 9, "DONE")); // внести изменения в Подзадачу
        //manager.updateSubtask(new Subtask("ПЗ 2.2", "НОВОЕ ОПИСАНИЕ ПЗ 2.2", 10, "DONE")); // внести изменения в Подзадачу

        //manager.removeTaskById(1); // удалить Задачу по номеру ID
        //manager.removeEpicById(3);  // удалить Эпик по номеру ID
        //manager.removeSubtaskById(5);  // удалить подзадачу по номеру ID
        //manager.removeSubtaskById(6);  // удалить подзадачу по номеру ID
        //manager.removeSubtaskById(7);  // удалить подзадачу по номеру ID
        //manager.removeSubtaskById(8);  // удалить подзадачу по номеру ID
        //manager.removeSubtaskById(9);  // удалить подзадачу по номеру ID
        //manager.removeSubtaskById(10);  // удалить подзадачу по номеру ID

        //manager.returnSubtask(4); // вернуть список подзадач эпика (ID эпика)
    }
}
