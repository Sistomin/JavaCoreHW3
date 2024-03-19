import java.time.LocalDate;

public class Task {

    //region Блок переменных
    private int id;
    private static int idCount = 0;
    private String title;
    private LocalDate deadline;
    private Worker executorTask;
    //endregion

    //region Блок конструкторов
    public Task(String title) {
        this.id = ++idCount;
        this.title = title;
        this.deadline = LocalDate.now().plusWeeks(2);
    }

    public Task(String title, LocalDate deadline) {
        this.id = ++idCount;
        this.title = title;
        this.deadline = deadline;
    }
    //endregion

    //region Гетторы и сетторы
    public Worker getExecutorTask() {
        return executorTask;
    }

    public void setExecutorTask(Worker executorTask) {
        this.executorTask = executorTask;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
    //endregion

    //region Перегрузка метода toString
    @Override
    public String toString() {
        return "Задача: " +
                "id=" + id +
                ", Содержание задачи: " + title + '\'' +
                ", срок исполнения: " + deadline +
                ", исполнитель: " + executorTask.getSurname() + " " + executorTask.getName() + "\n";
    }
    //endregion

}
