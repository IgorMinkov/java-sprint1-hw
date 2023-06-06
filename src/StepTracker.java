import java.util.Scanner;
class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        System.out.println("1 - январь, 2 - февраль, 3 - март ... 11 - ноябрь, 12 - декабрь");
        int month = scanner.nextInt();
        if ((month <1) || (month >12)) {
            System.out.println("Вы ввели несуществующий номер месяца");
            return;
        }

        System.out.println("Введите день от 1 до 30");
        int day = scanner.nextInt();
        if ((day <1) || (day >30)) {
            System.out.println("Вы ввели несуществующий в месяце день");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Количество шагов не может быть отрицательным");
            return;
        }

        // Получение соответствующего объекта MonthData из массива и сохранение данных
        MonthData monthData = monthToData[month - 1];
        monthData.days[day-1] = steps;
    }
// Иван: "Кроме того, введенное число у Вас никуда не записывается.
// Разве не нужно присвоить goalByStepsPerDay новое значение?"
    // Я - Переменную объявил и присвоил значение в классе StepTracker, 5я строка здесь.
    // при повторном вызове метода changeStepGoal выдает введенное число.
    // Либо вопрос решен, либо я не понял вашего замечания.

    void changeStepGoal() {
        System.out.println("Сейчас ваша цель - " + goalByStepsPerDay + " шагов в день");
        System.out.println("Введите новую цель по количеству шагов в день:");
        goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay <= 0) {
            System.out.println("цель не может быть нулевой или отрицательной");
            goalByStepsPerDay = 10000;
        } else {
        System.out.println("новая цель: " + goalByStepsPerDay + " шагов в день");
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        System.out.println("1 - январь, 2 - февраль, 3 - март ... 11 - ноябрь, 12 - декабрь");
        int month = scanner.nextInt();
        if ((month < 1) || (month > 12)) {
            System.out.println("Вы ввели несуществующий номер месяца");
            return;
        }
        MonthData monthData;
        Converter converter = new Converter();
        monthData = monthToData[month - 1]; // получение соответствующего месяца
        int sumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц

        System.out.println("Количество пройденных шагов по дням:"); // вывод общей статистики по дням
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Всего шагов за месяц: " + sumSteps);
        System.out.println("Максимум шагов за месяц: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов за месяц: " + (sumSteps/30));
        System.out.println("Пройдено км за месяц: " + converter.convertToKm(sumSteps));
        System.out.println("Сожжено килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия дней в этом месяце: " + monthData.bestSeries(goalByStepsPerDay));
    }

}
