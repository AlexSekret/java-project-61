package hexlet.code;

import hexlet.code.games.Calculator;

import java.util.Scanner;

public class Engine {

    static Scanner sc = new Scanner(System.in);
    static String userName = "";
    static String userChoice = "";
    private static int userAnswer;
    private static int correctAnswer;
    private static int counterCorrectAnswers;

    public static void getUserChoice() {
        userChoice = sc.next();
        printUserChoice();
    }

    private static void printUserChoice() {
        System.out.println("Your choice: " + userChoice);
    }

    public static void defaultGreet() {
        if (!userChoice.equals("0")) {
            System.out.println("""
                    Welcome to the Brain Games!
                    May I have your name?""");
        }
    }

    public static void setUserName() {
        userName = sc.next();
    }

    public static void printCalculatorGreetings() {
        System.out.println("Hello, " + userName + "\nWhat is the result of the expression?");
    }

    private static void printCalculatorQuestion() {
        System.out.println(Calculator.getQuestion());
    }

    private static void printAnswer() {
        userAnswer = Integer.parseInt(sc.next());
        System.out.println("Answer: " + userAnswer);
    }

    private static void getCalculatorCorrectAnswer() {
        correctAnswer = Calculator.getAnswer();
    }

    private static boolean checkCalculatorCorrectAnswer() {
        getCalculatorCorrectAnswer();
        return userAnswer == correctAnswer;
    }

    private static void printCalculatorResult() {
        if (checkCalculatorCorrectAnswer()) {
            System.out.println("Correct!");
            counterCorrectAnswers++;
        } else {
            System.out.println(userAnswer + " is wrong answer ;(. Correct answer was " + correctAnswer + ".\nLet's try again, " + userName);
        }

    }

    public static void playCalculator(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            printCalculatorQuestion();
            printAnswer();
            printCalculatorResult();
        }
    }

    public static void printWinLoose() {
        if (counterCorrectAnswers == 3) {
            System.out.println("Congratulations, " + userName);
        } else {
            System.out.println("Sorry! You loose. Try again.");
        }
    }
}
