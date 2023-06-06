class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() { // вывод количества пройденных шагов по дням
        for (int i = 0; i < days.length; i++) {
            System.out.println((i+1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() { // вывод суммы шагов в месяц
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    int maxSteps() { // максимум шагов в день за месяц
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    // У меня не воспроизвелась ошибка из ревью. При аналогичных вводных выдавало лучшую серию - 1 день.
    // Сделал скриншоты с подтверждением, исправлял вслепую.

    int bestSeries(int goalByStepsPerDay) { // максимальное количество подряд идущих дней с выполненной целью
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            // currentSeries = (days[i] >= goalByStepsPerDay) ? currentSeries + 1 : 0; // на QA-вебинаре показывали
            if (days[i] >= goalByStepsPerDay) { currentSeries++;
            } else {
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries; // поиск максимальной серии
            } else {
                    currentSeries = 0;
                }
            }
        }
        return finalSeries;
    }

}
