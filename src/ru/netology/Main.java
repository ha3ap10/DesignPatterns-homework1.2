package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        logger.log("Просим пользователя ввести входные данные для списка");
        int listSize = input("Введите размер списка: ");

        int maxValue = input("Введите верхнюю границу для значений: ");

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(maxValue));
        }

        System.out.print("Вот случайный список: ");
        list.stream().map(value -> value + " ").forEach(System.out::print);

        System.out.println();
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int filterValue = input("Введите порог для фильтра: ");

        Filter filter = new Filter(filterValue);
        List<Integer> filteredList = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        filteredList.stream().map(filteredValue -> filteredValue + " ").forEach(System.out::print);
    }

    public static int input(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
