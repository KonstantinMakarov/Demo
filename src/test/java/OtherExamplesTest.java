import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombokentity.Person;
import lombokentity.School;
import lombokentity.address.Address;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.ui.Quotes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.testng.annotations.Test;
import other.Link;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;


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
                    .collect(toList());
            System.out.println(result);
    }

    @Test
    void testAssertionsFormat() {
        Assertions.assertThat("true").as("error").isEqualTo("not true");
    }

    @Test
    void testJsonParser() throws IOException {
        String str = "{ \t\"name\": \"Gymnasium\", \t\"id\": \"7\", \t\"pupils\": [{\t\"name\": \"Bob\" \t},{\t\"name\": \"Alice\" \t}] }";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        School.Pupil pupil = objectMapper.readValue(str, School.Pupil.class);
    }

    @Test
    public void testUrlParameter() {
        String url = "https://uk.practicallaw.qed.thomsonreuters.com/Document/I53924361d8e611e698dc8b09b4f043e0/View/FullText.html?view=hidealldraftingnotes&transitionType=Default";
        String a = UriComponentsBuilder.fromHttpUrl(url)
                .replaceQueryParam("view", "urlViewParameter")
                .build().toString();
        System.out.println(a);
    }

    @Test
    public void testExtracting() {
        List<Link> links = asList(new Link("firstT", "firstH"), new Link("secondT", "SecondH"));
        Assertions.assertThat(links).as("size issue").hasSize(1).extracting("title").as("titleH").allMatch(title -> title.toString().endsWith("H"));
    }

    @Test
    public void tmp() {

    }
}