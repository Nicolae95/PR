package hello;
/**
 * Created by nicol on 30.03.2017.
 */
import org.joda.time.LocalTime;

public class HelloWord {
    public static void main(String[] args) {
        LocalTime currentTime;
        currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }
}
