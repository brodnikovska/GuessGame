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
        int minimum = INITIAL_LEFT_EDGE;
        int maximum = INITIAL_RIGHT_EDGE;
        model.setValue(getRandomInt(minimum, maximum));
        int secretValue = model.getValue();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> userChoices = new ArrayList<>();
        model.setUserGuess(inputIntValueWithScanner(sc));
        int currentValue = model.getUserGuess();
        while (secretValue!=currentValue) {
            System.out.println(SystemMessages.PREVIOUS_ATTEMPTS.toString() + gatherUserStatistics(userChoices, currentValue));
            System.out.println(SystemMessages.LAST_ATTEMPT.toString() + lastStats(userChoices));
            if (currentValue > secretValue & currentValue < maximum) {
                model.setMaxValue(currentValue);
                maximum = model.getMaxValue();

            } else if (currentValue < secretValue & currentValue > minimum) {
                model.setMinValue(currentValue);
                minimum = model.getMinValue();
            }
            System.out.println(String.format(SystemMessages.SELECTIVE_INT.toString(), minimum,
                    maximum));
            model.setUserGuess(inputIntValueWithScanner(sc));
            currentValue = model.getUserGuess();
        }
        System.out.println(String.format(SystemMessages.WIN_MESSAGE.toString(), secretValue));
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
