package OOP_3;
/* 
Создайте несколько экземпляров Pharmacy, причем, чтобы среди них было хотя 
бы два экземпляра
с полностью идентичными значениями полей.

Сделать так, чтобы после выполнения кода ниже, в сете result были только 
уникальные объекты.
Set<Pharmacy> result = new HashSet<>(множество из нескольких лекарств);
System.out.println(result.size()); // тут вывод должен быть равен количеству 
УНИКАЛЬНЫХ экземпляров Pharmacy!

Добавить интерфейс Copmparable<Pharmacy> к классу Pharmacy. 
Переопределить метод compareTo()
подсказка: можно добавить, а можно не добавлять в класс поля;
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        
        // Создаем и добавляем в сет элементы с одинаковыми компонентами
        Set<PharmancyComponent> Pharmacy = new HashSet<>();
        Pharmacy.add(new PharmancyComponent("Вода", "5", 15));
        Pharmacy.add(new PharmancyComponent("Вода", "5", 15));
        Pharmacy.add(new PharmancyComponent("Азитронит", "2", 6));
        Pharmacy.add(new PharmancyComponent("Пинициллин", "2", 6));
        Pharmacy.add(new PharmancyComponent("Пинициллин", "8", 10));
        System.out.println(Pharmacy + "\n");

        // Создаем список компонентов
        List<PharmancyComponent> pharmacy1 = List.of(
                new Azitronit("Азитронит", "4", 6),
                new Water("Вода", "20", 10));
        List<PharmancyComponent> pharmacy2 = List.of(
                new Azitronit("Азитронит","4",6),
                new Penicillin("Пенициллин", "16", 6));
        List<PharmancyComponent> pharmacy3 = List.of(
                new Water("Вода", "20", 10),
                new Azitronit("Азитронит", "10", 12));
        List<PharmancyComponent> pharmacy4 = List.of(
                new Water("Вода", "20", 1),
                new Penicillin("Пенициллин", "18", 12));
        List<PharmancyComponent> pharmacy5 = List.of(
                new Water("Вода", "10", 12),
                new Azitronit("Азитронит", "8", 12));
        List<PharmancyComponent> pharmacy6 = List.of(
                new Water("Вода", "5", 12),
                new Azitronit("Азитронит", "10", 10));

        
        // Создаем лекарства из разных компонентов
        Drug drug1 = new Drug(pharmacy1);
        Drug drug2 = new Drug(pharmacy2);
        Drug drug3 = new Drug(pharmacy3);
        Drug drug4 = new Drug(pharmacy4);
        Drug drug5 = new Drug(pharmacy5);
        Drug drug6 = new Drug(pharmacy6);

        // Создаем список лекарств
        List<Drug> drugs = new ArrayList<>();
        drugs.add(drug1);
        drugs.add(drug2);
        drugs.add(drug3);
        drugs.add(drug4);
        drugs.add(drug5);
        drugs.add(drug6);
        System.out.println("Выводим список лекарств");
        System.out.println(drugs);

        // Сортируем список лекарств по возрастанию силы
        System.out.println("Выводим отсортированный список лекарств");
        Collections.sort(drugs);
        System.out.println(drugs);
        System.out.println("Размер сета с лекарствами: " + drugs.size());
        System.out.println("Количество уникальных компонентов для изготовления лекарств в сете: " + Pharmacy.size());
    }
}

