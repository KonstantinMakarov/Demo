package demo;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.assertj.core.api.Assertions.assertThat;

public class TRTaskTest {

    private final String originalString = "TI(ti3; ti4) & CI(ci3; CI4) & (SUJ,KW(suj2; \"kw2 on smth\" CI(CI(CI))) & TI(ti3; ti4) \"smth on smth\" & CI(ci3; CI4)) & NO(number) & SUJ,KW(suj1; \"kw2 on smth\" kw sub)";

    @Test
    public void testDocFields() {
        List<String> tiDocField = asList("ti3;", "ti4");
        List<String> ciDocField = asList("ci3;", "CI4");
        List<String> noDocField = asList("number");
        List<String> sujkwDocField = asList("suj1;", "\"kw2", "on", "smth\"", "kw", "sub");

        assertThat(getDocFieldValue("TI", originalString)).isEqualTo(tiDocField);
        assertThat(getDocFieldValue("CI", originalString)).isEqualTo(ciDocField);
        assertThat(getDocFieldValue("NO", originalString)).isEqualTo(noDocField);
        assertThat(getDocFieldValue("SUJ,KW", originalString)).isEqualTo(sujkwDocField);
    }

    @Test
    public void testQueryAny() {
        assertThat(getFreeText(originalString)).isEqualTo("SUJ,KW(suj2; \"kw2 on smth\" CI(CI(CI))) & TI(ti3; ti4) \"smth on smth\" & CI(ci3; CI4)");
    }

    private List<String> getDocFieldValue(String docKey, String originalString) {
        String originalStringWithoutFreeText = StringUtils.remove(originalString, getFreeText(originalString));
        String pattern = String.format("%s\\((.*?)\\)", docKey);
        return asList(findByPattern(originalStringWithoutFreeText, pattern).split(SPACE));
    }

    private String getFreeText(String originalString) {
        String originalStringWithoutFirstPartOfDocFields = removeDocFieldsBeforeFreeText(originalString);
        originalString = StringUtils.removeStart(originalStringWithoutFirstPartOfDocFields, "(");
        String[] sections = originalString.split(" & ");
        int lastSectionNumberOfFreeText = getLastSectionIndexOfFreeText(sections);
        sections[lastSectionNumberOfFreeText] = StringUtils.removeEnd(sections[lastSectionNumberOfFreeText], ")");
        return Arrays.stream(sections).limit(lastSectionNumberOfFreeText + 1).collect(Collectors.joining(" & "));
    }

    private int getLastSectionIndexOfFreeText(String[] sections) {
        for (int i=0; i<sections.length; i++) {
            long openParenthesis = calculateSymbolNumberOfString(sections[i],"(");
            long closeParenthesis = calculateSymbolNumberOfString(sections[i],")");
            if (openParenthesis != closeParenthesis) {
                return i;
            }
        }
        throw new RuntimeException("Incorrect parenthesis structure");
    }

    private long calculateSymbolNumberOfString(String string, String character) {
        return string.chars().mapToObj(c -> String.valueOf((char) c)).filter(symbol -> symbol.equals(character)).count();
    }

    private String removeDocFieldsBeforeFreeText(String originalString) {
        String newString = EMPTY;
        while (!originalString.equals(newString)) {
            newString = originalString;
            String stringToRemove = findByPattern(originalString, "(^\\w+,*\\w*\\(.*?& )");
            originalString = StringUtils.removeStart(originalString, stringToRemove);
        }
        return newString;
    }

    private String findByPattern(String originalString, String customPattern) {
        Pattern pattern = Pattern.compile(customPattern);
        Matcher matcher = pattern.matcher(originalString);
        return matcher.find() ? matcher.group(1) : EMPTY;
    }

}