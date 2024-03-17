import java.util.Comparator;

//Task1 Компоратор по фамилии
public class WorkerFullNameComparator implements Comparator<Worker> {
        @Override
        public int compare(Worker o1, Worker o2){
            return o1.getSurname().compareTo(o2.getSurname());
        }

}
