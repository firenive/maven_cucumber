package steps.part1.chapter5;

import static org.junit.jupiter.api.Assertions.fail;

public class AssertionExample {
    public static void main(String[] args) {
        try {
            fail();
        } catch (AssertionError e) {
            System.out.print("Exception was raised was ");
            System.out.println(e.getClass().getName());
        }
    }
}
