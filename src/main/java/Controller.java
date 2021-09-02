import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static final int INITIAL_LEFT_EDGE = 0;
    private static final int INITIAL_RIGHT_EDGE = 100;

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void guessInt() {
        int leftEdge = INITIAL_LEFT_EDGE;
        int rightEdge = INITIAL_RIGHT_EDGE;
        final int NUMBER = getRandomInt(INITIAL_LEFT_EDGE, INITIAL_RIGHT_EDGE);
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> userChoices = new ArrayList<>();
        model.setValue(inputIntValueWithScanner(sc));
        int currentValue = model.getValue();
        while (NUMBER!=currentValue) {
            System.out.println(SystemMessages.PREVIOUS_ATTEMPTS.toString() + gatherUserStatistics(userChoices, currentValue));
            System.out.println(SystemMessages.LAST_ATTEMPT.toString() + lastStats(userChoices));
            if (currentValue > NUMBER) {
                rightEdge = currentValue;
            } else {
                leftEdge = currentValue;
            }
            System.out.println(String.format(SystemMessages.SELECTIVE_INT.toString(), leftEdge, rightEdge));
            model.setValue(inputIntValueWithScanner(sc));
            currentValue = model.getValue();
        }
        System.out.println(String.format(SystemMessages.WIN_MESSAGE.toString(), NUMBER));
    }

    public int getRandomInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min)));
    }

    public int inputIntValueWithScanner(Scanner sc) {
        view.printSystemMessage(SystemMessages.INPUT_INT.toString());
        while( ! sc.hasNextInt()) {
            view.printSystemMessage(SystemMessages.WRONG_INT.toString() + SystemMessages.INPUT_INT.toString());
            sc.next();
        }
        return sc.nextInt();
    }

    public ArrayList<Integer> gatherUserStatistics(ArrayList<Integer> choices, int choice) {
        choices.add(choice);
        return choices;
    }

    public int lastStats(ArrayList<Integer> choices) {
        return choices.get(choices.size() - 1);
    }

}
