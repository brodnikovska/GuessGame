import java.util.Scanner;

public class Controller {
    private static final String HELLO = "Hello";
    private static final String WORLD = "world";

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void gatherGreeting() {
        Scanner sc = new Scanner(System.in);
        model.setFirstWord(inputWordWithScanner(sc, HELLO));
        model.setSecondWord(inputWordWithScanner(sc, WORLD));
        view.printResult(model.greet());
    }

    public String inputWordWithScanner(Scanner sc, String expectedWord) {
        view.printSystemMessage(SystemMessages.INPUT_WORD.toString());
        String word = sc.nextLine();
        if (word.equals(expectedWord)) {
            return word;
        } else {
            while (!word.equals(expectedWord)) {
                view.printSystemMessage(SystemMessages.WRONG_WORD.toString() + SystemMessages.INPUT_WORD.toString());
                word = sc.nextLine();
            }
        } return word;
    }

}
