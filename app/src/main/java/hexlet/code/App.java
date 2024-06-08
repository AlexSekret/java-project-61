package hexlet.code;

import hexlet.code.games.EvenOddGame;

import java.util.Scanner;

//Файл App.java предназначен только для отображения игрового меню, выбора и запуска нужной игры
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                0 - Exit""");
        String userChoice = sc.next();
        System.out.println("Your choice: " + userChoice);
        switch (userChoice) {
            case "1":
                greet(sc);
                break;
            case "2":
                EvenOddGame.play();
                break;
            case "3":
                System.out.println("Nothing happen yet");
                break;
            default:
                break;
        }
    }
    public static void greet(Scanner sc) {
        System.out.println("Welcome to the Brain Games!\nMay I have your name?");
        String userName = sc.next();
        System.out.println("Hello, " + userName);
    }
}
