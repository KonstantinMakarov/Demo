package demo.java10;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VarTypeTest {

//    var classFiled = "error";

    public void errorVarExample() {
//        var users = new ArrayList<String>();
//        users = new LinkedList<String>();
//
//        var varString;
//        varString = "";
//
//        var ints = {0, 1, 2};
//        var appendSpace = a -> a + " ";
//        var compareString = String::compareTo;
//        //hard to understand what it should return
//        var productMetadata = getTextsFromWebElements(getProductsFromMetadata());
    }

    private List<String> getTextsFromWebElements(List<WebElement> webElements) {
        return webElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    private List<WebElement> getProductsFromMetadata() {
        return new ArrayList<>();
    }

    @Test
    public void testConnectionAndReader() throws IOException {
        var googleUrl = new URL("http://google.com");
        var connection = googleUrl.openConnection();
        var reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        reader.lines().forEach(System.out::println);
    }

    @Test
    public void testLoop() {
        var numbers = List.of("a", "b", "c");
        for (var nr : numbers) {
            System.out.println(nr + " ");
        }
    }

    @Test
    public void tryExample() {
        try (var file = new FileInputStream(new File("no-such-file"))) {
            new BufferedReader(new InputStreamReader(file))
                    .lines()
                    .forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println("There's actually no 'no-such-file'");
        }
    }
}
