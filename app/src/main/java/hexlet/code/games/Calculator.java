package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calculator {
    private static final String[] OP_LIST = new String[]{"+", "-", "*"};
    public static final int MAX_OPLIST_LENGTH = 3;
    private static String operator = "";
    private static int[] numbers = {0, 0};
    private static final int MAX_RAND_BOUND = 21;

    public static void start(int roundsCount) {
        //генерируем игровые данные
        String gameRule = "What is the result of the expression?";
        String[] questions = new String[roundsCount];
        String[] answers = new String[roundsCount];
        for (int i = 0; i < roundsCount; i++) {
            questions[i] = generateQuestion();
            answers[i] = String.valueOf(generateAnswer());
        }
        //и передаем их в `Engine`, здесь должен дергаться класс `Engine`
        Engine.playGame(gameRule, questions, answers, roundsCount);
    }

    private static String generateQuestion() {
        operator = Calculator.getRandomOperator();
        numbers = Calculator.getRandomNumbers();
        return numbers[0] + " " + operator + " " + numbers[1];
    }

    private static int generateAnswer() {
        switch (operator) {
            case "+":
                return numbers[0] + numbers[1];
            case "-":
                return numbers[0] - numbers[1];
            case "*":
                return numbers[0] * numbers[1];
            default:
                return 0;
        }
    }

    private static String getRandomOperator() {
        int rnd = Util.getRandomNumber(MAX_OPLIST_LENGTH);
        return OP_LIST[rnd];
    }

    private static int[] getRandomNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Util.getRandomNumber(MAX_RAND_BOUND);
        }
        return numbers;
    }
}
