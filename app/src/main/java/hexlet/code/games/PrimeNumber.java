package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class PrimeNumber {

    private static final int MAX_NUMBER_BOUNDARY = 9;
    private static int number;


    public static void start() {
        //генерируем игровые данные
        String[] questions = new String[Engine.MAX_ROUND_COUNT];
        String[] answers = new String[Engine.MAX_ROUND_COUNT];
        String gameRule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        for (int i = 0; i < Engine.MAX_ROUND_COUNT; i++) {
            questions[i] = generateQuestion();
            answers[i] = generateAnswer();
        }
        //и передаем их в `Engine`, здесь должен дергаться класс `Engine`
        Engine.playGame(gameRule, questions, answers);
    }

    public static String generateQuestion() {
        number = 1 + Util.getRandomNumber(MAX_NUMBER_BOUNDARY);
        return String.valueOf(number);
    }

    public static String generateAnswer() {
        return isPrime(number) ? "yes" : "no";
    }

    private static boolean isPrime(int num) {
        if (number < 2) {
            return false;
        }
        var divider = 2;
        while (divider <= number / 2) {
            if (number % divider == 0) {
                return false;
            }
            divider++;
        }
        return true;
    }

}
