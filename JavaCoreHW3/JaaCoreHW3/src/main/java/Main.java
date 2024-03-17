//Task1 Написать компоратор по фамилии

//Task2 Опишите класс руководителя (Manager), наследник от сотрудника.
//Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом,
//чтобы он мог поднять заработную плату всем, кроме руководителей. В основной программе создайте руководителя
//и поместите его в общий массив сотрудников. Повысьте зарплату всем сотрудникам и проследите,
//чтобы зарплата руководителя не повысилась.

//Task3 Добавить возможность сотрудникам брать на себя задачу
//(реализовать либо как String, либо как объект класса Task) - например, метод assign(Task task).
//У руководителя должна быть возможность ставить задачу сотруднику, используя перегрузку
//метода assign(...) и брать задачу себе.

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Сoздали массив из 5 работников
        Worker[] workers = {
                new Worker("Ivanov", "Ivan", "Ivanovich", "Backender",
                "89990010203", 100, LocalDate.of(1975, 10, 17)),
                new Worker("Petrov", "Petr", "Petrovich", "manager",
                "+7-999-001-02-02", 200, LocalDate.of(1979, 11, 17)),
                new Worker("Sidorov", "Sergey", "Ivanovich", "Tehnik",
                        "+79990010299", 50, LocalDate.of(1965, 12, 01)),
                new Worker("Warner", "Esj", "Ivanovich", "Backender",
                        "+7999001111", 150, LocalDate.of(1995, 07, 27)),
                new Worker("Rudenko", "Anton", "Pavlovich", "IT-derektor",
                        "+7-990-000-0101", 500, LocalDate.of(1978, 02, 01))
        };

        //region Task2

        //Task2
        //Опишите класс руководителя (Manager), наследник от сотрудника.
        //Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом,
        //чтобы он мог поднять заработную плату всем, кроме руководителей.
        //(Класс создал, метод перенес, так же модифичировал метод)

        // Сoздал массив workers2 из 5 работников + Manager
        Worker[] workers2 = {
                new Worker("Petrov", "Petr", "Petrovich", "manager",
                        "+7-999-001-02-02", 200, LocalDate.of(1979, 11, 17)),
                new Worker("Ivanov", "Ivan", "Ivanovich", "Backender",
                        "89990010203", 100, LocalDate.of(1975, 10, 17)),
                new Manager("Zaicev", "Jliy", "Semenovich", "Manager",
                        "+7-990-000-0000", 500, LocalDate.of(1977, 02, 01)),
                new Worker("Sidorov", "Sergey", "Ivanovich", "Tehnik",
                        "+79990010299", 50, LocalDate.of(1965, 12, 01)),
                new Worker("Warner", "Esj", "Ivanovich", "Backender",
                        "+7999001111", 150, LocalDate.of(1995, 07, 27)),
                new Worker("Rudenko", "Anton", "Pavlovich", "IT-derektor",
                        "+7-990-000-0101", 500, LocalDate.of(1978, 02, 01))

        };
        // Проверка Task2:
        System.out.println("Task2: ");
        System.out.println("Выводим информациюю о работниках и Менеджере до повышения ЗП:");
        System.out.println(Arrays.toString(workers2)); //Выводим информациюю о работниках и Менеджере до повышения ЗП
        Manager.addSalaryFromManager(workers2, 45, 100); //вызываем метод повышения ЗП от Менеджера
        System.out.println("Выводим информациюю о работниках и Менеджере после повышения ЗП:");
        System.out.println(Arrays.toString(workers2));
        System.out.println("-----".repeat(5));

        //endregion



        //region Блок проверок(вывод в консоль) c семинара:

        System.out.println("-----".repeat(5));
        // Вывести средниий возраст работников
        System.out.println("Average age: " + getAverageAge(workers));
        // ВАывести среднию зарплату работников
        System.out.println("Average salary: " + getAverageSalery(workers));

        // Увеличить ЗП работникам
        System.out.println("-----".repeat(5));
        System.out.println("Прибавка к ЗП в размере 50, для сотрудников старше 45 лет: ");
        Worker.addSalary(workers, 45, 50);
        System.out.println(Arrays.toString(workers));

        // компоратор
        System.out.println("-----".repeat(5));
        // Компоратор(сортировка) по возрасту
        System.out.println("Сортировка по возрасту: ");
        List<Worker> workerList = Arrays.asList(workers);
        Collections.sort(workerList);
        System.out.println(workerList);

        System.out.println("-----".repeat(5));
        // Компоратор(сортировка) по зарплате
        System.out.println("Сортировка по зарплате: ");
        workerList.sort(new WorkerSalaryComparator());
        System.out.println(workerList);

        //Вывод Task1
        System.out.println("-----".repeat(5));
        // Компоратор(сортировка) по фамилии
        System.out.println("Task1 - Сортировка по фамилии: ");
        List<Worker> workerList2 = Arrays.asList(workers2);
        workerList2.sort(new WorkerFullNameComparator());
        System.out.println(workerList2);




        System.out.println("-----".repeat(5));
        // Компоратор(сортировка) по возрасту вариант 2
        System.out.println("Сортировка по возрасту (вариант2): ");
        workerList.sort((o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(workerList);

        //endregion


    }

    //region Метод получения среднего возраста работников
    public static double getAverageAge(Worker[] array){
        double sumAge = 0;
        for (Worker worker : array) {
            sumAge += worker.getAge();
        }
        return sumAge / array.length;
    }
    //endregion

    //region Метод получения средней зарплаты работников
    public static double getAverageSalery(Worker[] array){
        double sumSalary = 0;
        for (Worker worker : array) {
            sumSalary += worker.getSalary();
        }
        return sumSalary / array.length;
    }
    //endregion



}
