import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ArrayList<String> words = new ArrayList<>();
        words.add("рыбак");
        words.add("якорь");
        words.add("моряк");
        words.add("крыло");
        words.add("виселица");
        GallowsGame game = new GallowsGame(words);
        game.startGame();

    }
}