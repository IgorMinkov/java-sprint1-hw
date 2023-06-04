import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        System.out.println(); // просто пустая строка для отделения в консоли от технической инфы.
        System.out.println("Привет!");
        while (true) {
            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay(); // ввести количество шагов за определённый день
            } else if (i == 2) {
                stepTracker.changeStepGoal();// изменить цель по количеству шагов в день
            } else if (i == 3) {
                stepTracker.printStatistic();// напечатать статистику за определённый месяц
            } else if (i == 4) {
                System.out.println("До новых встреч!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    static void printMenu() { // Вывод доступных команд
        System.out.println(); // просто пустая строка для отделения меню от результатов
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("4 - выйти из приложения");
    }

}
