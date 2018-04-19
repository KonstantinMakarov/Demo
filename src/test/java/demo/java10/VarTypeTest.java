package demo.java10;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VarTypeTest {

//    var classFiled = "error";

    @Test
    public void varTypeJava9Test() {
        String varString = "Java9";
        List<String> productMetadata = getTextsFromWebElements(getProductsFromMetadata());
    }

    @Test
    public void varTypeJava10Test() {
//        var varString = "Java10";
//        var productMetadata = getTextsFromWebElements(getProductsFromMetadata());
//
//        System.out.println(varString);
//
//        var methodField = 4;
//        methodField = 1;
//
//        System.out.println(methodField);
    }

    private List<String> getTextsFromWebElements(List<WebElement> webElements) {
        return webElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private List<WebElement> getProductsFromMetadata() {
        return new ArrayList<>();
    }

}
