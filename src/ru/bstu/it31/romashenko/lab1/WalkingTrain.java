package ru.bstu.it31.romashenko.lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.Scanner;

/** @author Ромащенко Н.А.
 *
 * @version 1. 21.02.19
 *
 * Имя класса: WalkingTrain
 *
 * Назначение: для обработки данных, связанных с пробежкой
 */

public class WalkingTrain {
    private double todayDistance;
    private double dailyNorm;
    private int days;
    private double maxDistance;

    public double getDailyNorm() {
        return dailyNorm;
    }

    public double getDays() {
        return days;
    }

    public double getFirstDistance() {
        return todayDistance;
    }

    public void setDailyNorm(double dailyNorm) {
        this.dailyNorm = dailyNorm;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setFirstDistance(double firstDistance) {
        this.todayDistance = firstDistance;
    }

    // проверко корректности данных
    private boolean check(){
        if (0 >= this.todayDistance || 0 >= this.dailyNorm  || 0 >= days) {
            return false;
        }
        return true;
    }

    // Получение макс.дистанции
    public double getMaxDistance(){
        if (!check()){
            return -1;
        }
        this.maxDistance = this.todayDistance;

        System.out.println("Считать через:");
        System.out.println("\t> 1. For");
        System.out.println("\t> 2. While");

        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        switch (mode) {
            case 1: {
                for (int day = 2; day <= this.days; ++day) {
                    this.todayDistance += this.todayDistance * this.dailyNorm / 100;
                    this.maxDistance += this.todayDistance;
                }
                break;
            }
            case 2: {
                int day = 2;
                while (day <= this.days) {
                    this.todayDistance += this.todayDistance * this.dailyNorm / 100;
                    this.maxDistance += this.todayDistance;
                    ++day;
                }
                break;
            }
            default: {
                System.out.println("Некорректный ввод.");
                return -1;
            }
        }
        return this.maxDistance;
    }

    // Получение данных из файла
    public void getValueFromFile() {
        try (FileReader reader = new FileReader("ex3.txt")) {
            BufferedReader r = new BufferedReader(reader);
            String temp = r.readLine();
            this.todayDistance = Double.parseDouble(temp);
            temp = r.readLine();
            this.dailyNorm = Double.parseDouble(temp);
            temp = r.readLine();
            this.days = Integer.parseInt(temp);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Считываение данных из файла
    public void printValueInFile() {
        try (FileWriter writer = new FileWriter("ex3_otvet.txt", false)) {
            String text = ""
                    + "firstDistance = " + this.todayDistance + " км" + '\n'
                    + "dailyNorm = " + this.dailyNorm + " %" + '\n'
                    + "days = " + this.days + '\n'
                    + "maxDistance = " + this.maxDistance +" км" +  '\n';
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
