import lombok.Person;
import lombok.address.Address;
import org.openqa.selenium.support.ui.Quotes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OtherExamplesTest {

    void robot() throws AWTException {
            Robot robot = new Robot();
            robot.delay(3000);
            while (true) {
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.delay(1000);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
            }
    }

    public void restGet() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://us.p02edi.practicallaw.com/cs/Satellite/" +
                        "?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=9-376-4010", String.class);
        System.out.println(response.getBody());
    }

    @Test
    public void quotesEscape() {
        String a = "//a[@id=" + Quotes.escape("Ivan ' friend") + "]";
        System.out.println(a);
    }

    @Test
    void lombokDemo() {
        Person person = new Person("Bob", new Address("SomeStreet", 10));
        person.setAddress(new Address("New Street", 15));
        System.out.println(person.toString());
    }

    @Test
    void peekStream() {
            List<String> result = Stream.of("EURO/INR", "USD/AUD", "USD/GBP", "USD/EURO")
                    .filter(e -> e.length() > 7)
                    .peek(System.out::println)
                    .map(String::toLowerCase)
                    .peek(System.out::println)
                    .collect(Collectors.toList());
            System.out.println(result);
    }

}