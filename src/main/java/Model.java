public class Model {

    private int userGuess;
    private int minValue;
    private int maxValue;
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int currentValue) {
        this.value = currentValue;
    }

    public int getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
