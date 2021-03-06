package demo.java9;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JShellTest {

    @Test
    public void regexDemo() {
        Pattern pattern = Pattern.compile("Dear Mr. (\\w+),");
        Matcher matcher = pattern.matcher("Dear Mr. Constantine,\n I would like to...");
//        matcher.find() ? matcher.group(1) : null;
        System.out.println(matcher.find() ? matcher.group(1) : StringUtils.INDEX_NOT_FOUND);
    }

}