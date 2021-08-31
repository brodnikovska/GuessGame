import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GreetingTest {

    @Test
    public void shouldGreet() {
        String hello = new Greeting().greet();
        assertTrue(String.format(SystemMessages.WRONG_GREETING.toString(), SystemMessages.HELLO_WORLD, hello),
                hello.equals(SystemMessages.HELLO_WORLD.toString()));
    }
}
