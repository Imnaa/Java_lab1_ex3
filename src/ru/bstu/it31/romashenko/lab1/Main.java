package ru.bstu.it31.romashenko.lab1;

import java.util.Scanner;

/** @author Ромащенко Н.А.
 *
 * @version 1. 21.02.19
 *
 * Имя класса: Main
 *
 * Назначение: Начав тренировки, спортсмен в первый день пробежал n км.  Каждый день он увеличивал дневную норму на m% нормы предыдущего дня. Какой суммарный путь пробежит спортсмен за k дней?
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Определение дистанции");
        System.out.println("\t> 1. Ввести с помощью клавиатуры;");
        System.out.println("\t> 2. Считать из файла;");
        System.out.println("\t> 9. Выход.");
        // Режим ввода данных
        // 1 - клавиатура
        // 2 - файл
        // 9 - выход

        // Инициализация объекта "Сканер"
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        // Инициализация объекта "walkingTrain"
        WalkingTrain walkingTrain = new WalkingTrain();
        // Обработка режима работы
        switch (mode) {
            // Клавиатура
            case 1: {
                // Ввод
                System.out.print("Первый день пробел км: ");
                walkingTrain.setFirstDistance(scanner.nextDouble());
                System.out.print("Дневная норма %: ");
                walkingTrain.setDailyNorm(scanner.nextDouble());
                System.out.print("Дней на побегать: ");
                walkingTrain.setDays(scanner.nextInt());
                break;
            }
            // Файл
            case 2: {
                // Функция для считывания из файла
                walkingTrain.getValueFromFile();
                break;
            }
            // Выход
            case 9: {
                scanner.close();
                return;
            }
            // Ошибка ввода
            default: {
                System.out.println("Неправильный ввод.");
                scanner.close();
                return;
            }
        }
        // Получаем макс. дистаницю
        double maxDistance = walkingTrain.getMaxDistance();
        // Проверка на посчитать
        if (-1 == maxDistance) {
            // Обработка ошибки
            scanner.close();
            return;
        }
        System.out.println("Спортсмен пробежал " + maxDistance + " км.");
        walkingTrain.printValueInFile();
        scanner.close();
    }
}
