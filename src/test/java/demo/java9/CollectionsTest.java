package demo.java9;

import org.testng.annotations.Test;

import java.util.*;

import static java.util.Map.entry;

public class CollectionsTest {

    @Test
    public void collectionJava8() {
        List<String> listStr = Arrays.asList("First", "Second");
        Set<String> set = new HashSet<>();
        set.add("First");
        set.add("Second");
        set.add("First");
    }

    @Test
    public void collectionsDemo() {
        Set<String> set = Set.of("Minsk", "Vitebsk");
        Map<Integer, String> cities = Map.of(1,"Minsk", 2, "Vitebsk");
        Map<Integer, String> citiesEntries = Map.ofEntries(entry(1,"Minsk"), entry(2, "Vitebsk"));
    }
}
