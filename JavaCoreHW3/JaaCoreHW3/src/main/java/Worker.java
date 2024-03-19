import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Создать класс ”Сотрудник” с полями: ФИО, должность, телефон, зарплата, возраст;
public class Worker implements Comparable<Worker> {
    //region Объявляяем переменные
    private String surname;
    private String name;
    private String middleName;
    private String position;
    private String phoneNumber;
    private int salary;
    private LocalDate birthDate;
    //endregion

    //region Конструктор
    public Worker(String surname, String name, String middleName, String position,
                  String phoneNumber, int salary, LocalDate birthDate) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        setBirthDate(birthDate);
    }
    //endregion

    //region Конструктор только по ФИО
    public Worker(String surname, String name, String middleName) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
    }
    //endregion

    //region Гетторы и Сетторы
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Геттор на возраст работника на основе его даты рожденя
    public int getAge() {
        return this.birthDate == null ? -1 : (int) this.birthDate.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    // Переработана логика добавления возраста работника на основе его даты рожденя
    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null || birthDate.isAfter(LocalDate.now().minusYears(14))) {
            System.out.println("Дата рождения работника задана не корректно!!!");;
        }else {
            this.birthDate = birthDate;
        }
    }
    //endregion

    //region Переопределяяем метод toString
    @Override
    public String toString() {
        return "Worker{" +
        "surname='" + surname + '\'' +
        ", name='" + name + '\'' +
        ", middleName='" + middleName + '\'' +
        ", position='" + position + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", salary=" + salary +
        ", age=" + this.getAge() +
        '}' + "\n";
    }
    //endregion

    //region Метод увеличения ЗП работникам
    /**
     * Метод увеличения ЗП работникам
     * @param workers Массив работников
     * @param age возраст старше коророго увеличиваем ЗП
     * @param addAmont кол-во единиц на сколько увеличиваем ЗП
     */
    public static void addSalary(Worker[] workers, int age, int addAmont){
        for (Worker worker : workers) {
            if (worker.getAge() >= age){
                worker.setSalary(worker.getSalary() + addAmont);
            }
        }
        System.out.println("Зарплата повышена успешно!!! Для роботников старше " + age + " на " + addAmont);
    }
    //endregion

    //region компарация
    @Override
    public int compareTo(Worker o) {
        return this.getAge() - o.getAge();
    }
    //endregion

    //region Task3 Метод назначения на себя задачи
    private Task currentTask;

    public Task getCurrentTask() {
        return currentTask;
    }
    //endregion

    //region Task3 Метод закрепления задачи и сохранения исполнителя
    public void assign(Task task) {

        // Закрепление задачи за работником
        this.currentTask = task;

        // Сохранение исполнителя в задаче
        task.setExecutorTask(this);
    }
    //endregion

}
