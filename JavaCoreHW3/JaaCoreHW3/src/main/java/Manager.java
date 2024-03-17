import java.time.LocalDate;

//Task2 JavaCore HW3
//Опишите класс руководителя (Manager), наследник от сотрудника.
// Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом,
// чтобы он мог поднять заработную плату всем, кроме руководителей.

public class Manager extends Worker {

    // Конструктор

    public Manager(String surname, String name, String middleName, String position, String phoneNumber,
                   int salary, LocalDate birthDate) {
        super(surname, name, middleName, position, phoneNumber, salary, birthDate);
    }

    // Метод повышения зарплаты
    public static void addSalaryFromManager(Worker[] workers, int age, int addAmont){
        for (Worker worker : workers) {
            if (!(worker instanceof Manager)) {
                if (worker.getAge() >= age) {
                    worker.setSalary(worker.getSalary() + addAmont);
                }
            }
        }
        System.out.println("Зарплата повышена успешно!!! Для роботников старше " + age + " на " + addAmont);
    }
}
