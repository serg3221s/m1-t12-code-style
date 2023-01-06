import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateFinalDepositAmount();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return roundToSpecifiedDecPlaces(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundToSpecifiedDecPlaces(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundToSpecifiedDecPlaces(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void calculateFinalDepositAmount() {
        int period;
        int action;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = userInput.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = userInput.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = userInput.nextInt();

        double outDoubleVar = 0;

        if (action == 1) {
            outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }
}
