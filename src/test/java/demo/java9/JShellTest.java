package demo.java9;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JShellTest {

    @Test
    void regexDemo() {
        Pattern pattern = Pattern.compile("Dear Mr. (\\w+),");
        Matcher matcher = pattern.matcher("Dear Mr. Constantine,\n I would like to...");
//        matcher.find() ? matcher.group(1) : null;
        System.out.println(matcher.find() ? matcher.group(1) : null);
    }



}