package com.unique.pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonFactory {

    public static final Random RANDOM = new Random();
    private static final String FIRST_NAMES = "Макар Шарль Цефас Шамиль Юлий Карл Святослав Евгений Ян Карл Глеб " +
            "Устин Иннокентий Чарльз Борис Игнатий Цефас Чеслав Жигер Йоган Людовик Глеб Чеслав Пётр Елисей Марк " +
            "Ярослав Филипп Алексей Цезарь Альберт Ираклий Шарль Виталий Филипп Жерар Устин Эрик Цицерон Чарльз " +
            "Лукиллиан Феликс Ярослав Чарльз Мирослав Трофим Родион Тит Марат Гарри Ольга Полина Божена Харитина " +
            "Дина Владлена Ягетта Доминика Шушана Элеонора Беатриса Розалина Ксения Елена Чеслава Лада Олеся " +
            "Харитина Олеся Устинья Яэль Любовь Ягетта Гражина Клементина Нина Жасмин Пелагея Харитина " +
            "Нина Рада Богдана Эльга Фаина Юнона Клементина Прасковья Юна Георгина Елизавета Тамара Светлана " +
            "Гелена Надежда Маргарита Эдита Христина Октябрина Валерия Октябрина ";
    private static final String LAST_NAMES = "Доронина Ковальчук Маслова Королёва Федоренко Чернова Крылова Щербакова" +
            " Майборода Навальна Уварова Антонова Спивак Горобчук Меркушева Горшкова Андрейко Трофимова Стрелкова " +
            "Сусаренко Фомичёва Панфилова Нестерова Медведева Макарова Гришина Тимофеева Селиверстова " +
            "Селиверстова Куликова Носкова Игнатьева Русакова Яценюк Пахомова Субботина Ширяева Терещенко " +
            "Исакова Маслова Лукина Лобанова Шухевич Карпова Калашникова Калашникова Мишина Цушко Хитрук " +
            "Вишнякова Хохлов Чернов Белоусов Житар Спивак Королёв Желиба Красильников Гамула Кудряшов " +
            "Сасько Сусаренко Щукин Посидайло Никонов Гелетей Трясило Максимов Сирко Белоусов Евдокимов " +
            "Ларионов Гелетей Корнейчук Тетерин Кондратьев Фёдоров Евсеев Самсонов Орлов Копылов Мартынов " +
            "Хитрук Селезнёв Русаков Крюков Многогрешный Линник Ермаков Ермаков Хохлов Забужко Беляков Колобов " +
            "Горобчук Андрусейко Лановой Федункив Коцюбинский Егоров ";
    private final List<Person> PERSON_LIST = new ArrayList<>();

    public PersonFactory(){
    }

    public List<Person> generatePersonList(int count) {
        for (int i = 0; i < count; i++) {
            Person person = createPerson();
            PERSON_LIST.add(person);
        }
        return PERSON_LIST;
    }

    private Person createPerson() {
        String[] firstNamesArray = FIRST_NAMES.split("\\s");
        String[] lastNamesArray = LAST_NAMES.split("\\s");
        String firstName = firstNamesArray[RANDOM.nextInt(firstNamesArray.length)];
        String lastName = lastNamesArray[RANDOM.nextInt(lastNamesArray.length)];
        double height = generateHeight();
        double weight = generateWeight(height);
        int age = generateAge(height);
        return new Person(firstName, lastName, age, weight, height);
    }

    private double generateHeight() {
        double start = 50;
        double end = 200;
        double random = RANDOM.nextDouble();
        double result = start + (random * (end - start));
        return Math.round(result * 10) / 10.0;
    }

    private double generateWeight(double height) {
        // Согласно ндексу Ноордена. Нормальная масса тела = рост[см] • 0,42 (сделаю коэф. 0.32 - 0.52)
        double weightIndex = (RANDOM.nextInt(21) + 32) / 100.0;
        return Math.round((height * weightIndex * 10)) / 10.0;
    }

    private int generateAge(double height) {
        if (height < 75) {
            return RANDOM.nextInt(1) + 1;
        } else if (height < 100) {
            return RANDOM.nextInt(2) + 3;
        } else if (height < 125) {
            return RANDOM.nextInt(6) + 6;
        } else if (height < 150) {
            return RANDOM.nextInt(5) + 11;
        } else {
            return RANDOM.nextInt(86) + 15;
        }
    }
}
