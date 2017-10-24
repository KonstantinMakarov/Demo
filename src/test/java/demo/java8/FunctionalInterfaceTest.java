package demo.java8;

import com.google.common.util.concurrent.Uninterruptibles;
import functional.interfaces.TriFunction;
import functional.interfaces.supplier.HttpUtils;
import lombok.Person;
import lombok.address.Address;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfaceTest {

    @Test
    void compareToDemo() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Bob", new Address("Bob Street", 10)));
        persons.add(new Person("Alice", new Address("Alice avenue", 183)));
        persons.add(new Person("John", new Address("John square", 34)));

        persons.sort((Person person1, Person person2) -> person1.getName().compareTo(person2.getName()));
        System.out.println(persons);
    }

    @Test
    void functionDemo() {
        //waitWlukRootTopicsPopulated() - example of Function (waitFor)
        int sum = performInversion(6, 8, 10, (x, y, z) -> x + y + z);
        int mult = performInversion(3, 4, 5, (x, y, z) -> x * y * z);
        System.out.println(sum + "; " + mult);

        //Alex should send her example of custom function
    }

    private int performInversion(int x, int y, int z, TriFunction<Integer, Integer, Integer, Integer> function) {
        return -function.apply(x, y, z);
    }

    @Test
    void supplierFunctionalInterfaceDemo() {
        System.out.println(getDataFromServerWithDelay(0, () -> HttpUtils.sendRequestAndGetTime()));
        System.out.println(getDataFromServerWithDelay(5, () -> HttpUtils.sendRequestAndGetDate()));

        //performActionsInIFrame() could also be considered as example
    }

    private String getDataFromServerWithDelay(int waitBeforeStart, Supplier<String> supplier) {
        //to emulate user behavior and to be recognized as not DDoS attack
        Uninterruptibles.sleepUninterruptibly(waitBeforeStart, TimeUnit.MILLISECONDS);
        return supplier.get();
    }

    @Test
    void consumerFunctionalInterfaceDemo() {
        Map<String, String> ages = new HashMap<>();
        ages.put("John25", "25");
        ages.put("Freddy24", "24");
        ages.put("Samuel30", "30");

        ages.forEach((name, age) -> System.out.println(StringUtils.remove(name, age)));
    }

    @Test
    void predicateFunctionalInterfaceDemo() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Bob", new Address("Bob Street", 10)));
        persons.add(new Person("Alice", new Address("Alice avenue", 183)));
        persons.add(new Person("John", new Address("John square", 34)));

        List<Person> filteredByHouseNumber = filterPersons(persons, person -> person.getAddress().getHouseNumber() > 99);
        System.out.println(filteredByHouseNumber);

        List<Person> filteredByStreet = filterPersons(persons, person -> person.getAddress().getStreet().contains("square"));
        System.out.println(filteredByStreet);
    }

    private List<Person> filterPersons(List<Person> persons, Predicate<Person> predicate) {
        return persons.stream().filter(predicate).collect(Collectors.toList());
    }
}
