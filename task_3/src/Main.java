import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordGenerator pwdGenerator = new PasswordGenerator();
        outer: while (true){
            System.out.print("Для генерации случайного пароля укажите его длину от 8 до 12: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Для генерации случайного пароля укажите его длину от 8 до 12: ");
            }
            switch (scanner.nextInt()) {
                case 8:
                    pwdGenerator.setLength(PasswordGenerator.PasswordLength._8);
                    break outer;
                case 9:
                    pwdGenerator.setLength(PasswordGenerator.PasswordLength._9);
                    break outer;
                case 10:
                    pwdGenerator.setLength(PasswordGenerator.PasswordLength._10);
                    break outer;
                case 11:
                    pwdGenerator.setLength(PasswordGenerator.PasswordLength._11);
                    break outer;
                case 12:
                    pwdGenerator.setLength(PasswordGenerator.PasswordLength._12);
                    break outer;
                default:
                    break;
            }
        }
        scanner.close();
        String password = pwdGenerator.getPassword();
        System.out.println("Сгенерирован пароль: " + password);
    }
}