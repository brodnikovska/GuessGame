import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class TestController {
    private Model model;
    private View view;
    private Controller controller;

    @Before
    public void createObjects() {
        model = new Model();
        view = new View();
        controller = new Controller(model, view);
    }

    @Test
    public void testRandomInt() {
        ArrayList<Integer> numbersArrayOne = new ArrayList<>();
        ArrayList<Integer> numbersArrayTwo = new ArrayList<>();
        IntStream.rangeClosed(0, 1000).forEach(i -> {
                    int number = controller.getRandomInt(0, 100);
                    numbersArrayOne.add(number);
                }
        );
        IntStream.rangeClosed(0, 1000).forEach(i -> {
                    int number = controller.getRandomInt(0, 100);
                    numbersArrayTwo.add(number);
                }
        );
        Assert.assertNotSame("Two arrays are the same", numbersArrayOne, numbersArrayTwo);
    }

    @Test
    public void testGatherUserStatistics() {
        ArrayList<Integer> initialArrayList = new ArrayList<>();
        int choice = 1;
        controller.gatherUserStatistics(initialArrayList, choice);
        Assert.assertTrue("User's choice is not included not ArrayList", initialArrayList.get(0) == choice);
    }

    @Test
    public void testLastStats() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(1);
        Assert.assertFalse("lastStats() method returns not the las value entred by user", controller.lastStats(arrayList)==2);
        controller.lastStats(arrayList);
    }

}
