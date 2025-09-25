import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GallowsGame {
    private final ArrayList<String> wordsToGuess = new ArrayList<>();
    private int errorsCount = 0;
    private int visibleCount = 0;
    private String[] image;
    private final Random random = new Random();
    boolean[] mask;

    private void buildImage() {
        image = new String[]{
                "  ___  ",
                " |  |  ",
                " |     ",
                " |     ",
                " |     ",
                " |     ",
                "=+==== "};
    }

    private void updateImage() {
        switch (errorsCount) {
            case 1:
                image[2] = " |  0  ";
                break;
            case 2:
                image[3] = " |  |  ";
                break;
            case 3:
                image[3] = " | /|  ";
                break;
            case 4:
                image[3] = " | /|\\ ";
                break;
            case 5:
                image[4] = " | /   ";
                break;
            case 6:
                image[4] = " | / \\ ";
                break;
        }
    }

    private void printImage(String hiddenWord){
        for (String i : image)
            System.out.println(i);
        for (int i = 0; i < hiddenWord.length(); ++i) {
            if (mask[i])
                System.out.print(hiddenWord.charAt(i));
            else
                System.out.print('-');
        }
        System.out.println();
        System.out.println("У вас осталось " + (6 - errorsCount) +
                (errorsCount < 2 || errorsCount == 6 ? " жизней":
                        (errorsCount < 5 ? " жизни" : " жизнь")));
    }

    public GallowsGame(ArrayList<String> wordsToGuess) {
        for (String i : wordsToGuess)
            this.wordsToGuess.add(i.toUpperCase());
        buildImage();
    }

    public void startGame() {
        System.out.println("Игра \"ВИСЕЛИЦА\"");
        String hiddenWord = wordsToGuess.get(random.nextInt(wordsToGuess.size()));
        System.out.println("Угадайте слово из " + hiddenWord.length() + " букв.");
        Scanner scanner = new Scanner(System.in);
        mask = new boolean[hiddenWord.length()];
        char curChar;
        boolean check;
        while (errorsCount < 6 && visibleCount < hiddenWord.length()) {
            printImage(hiddenWord);
            System.out.print("Введите букву: ");
            while (!scanner.hasNext("[а-яА-ЯёЁ]")) {
                System.out.print("Ошибка ввода. Введите букву: ");
                scanner.next();
            }
            curChar = (scanner.next().toUpperCase()).charAt(0);
            check = false;
            for (int i = 0; i < hiddenWord.length(); ++i) {
                if (hiddenWord.charAt(i) == curChar) {
                    mask[i] = true;
                    ++visibleCount;
                    check = true;
                }
            }
            if (!check) {
                ++errorsCount;
                updateImage();
            }
        }
        printImage(hiddenWord);
        if (errorsCount > 5)
            System.out.println("Вы проиграли");
        else
            System.out.println("Вы выиграли");

        scanner.close();
    }


}
