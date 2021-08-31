public class Greeting {
    private static final String GREETING = SystemMessages.HELLO_WORLD.toString();

    public String greet() {
        System.out.println(GREETING);
        return "GREETING";
    }
 }
