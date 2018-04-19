package demo.java8;

import lombokentity.Person;
import lombokentity.address.Address;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    @Test
    public void showStreamsVsVanillaDemo() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Bob", new Address("Bob Street", 10)));
        persons.add(new Person("Alice", new Address("Alice avenue", 183)));
        persons.add(new Person("John", new Address("John square", 34)));

        System.out.println(getSortedPersonNamesWhoHasHouseNumberLessThen(persons, 100));
        System.out.println(getStreamSortedPersonNamesWhoHasHouseNumberLessThen(persons, 150));
    }

    List<String> getSortedPersonNamesWhoHasHouseNumberLessThen(List<Person> persons, int limitHouseNumber) {
        List<Person> filteredPersons = new ArrayList<>();
        List<String> filteredAndSortedPersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAddress().getHouseNumber() < limitHouseNumber) {
                filteredPersons.add(person);
            }
        }

        Collections.sort(filteredPersons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAddress().getHouseNumber(), p2.getAddress().getHouseNumber());
            }
        });

        for (Person person: filteredPersons) {
            filteredAndSortedPersons.add(person.getName());
        }

        return filteredAndSortedPersons;
    }

    List<String> getStreamSortedPersonNamesWhoHasHouseNumberLessThen(List<Person> persons, int limitHouseNumber) {
        return persons.stream()
                .filter(person -> person.getAddress().getHouseNumber() < limitHouseNumber)
                .sorted(Comparator.comparing(person -> person.getAddress().getHouseNumber()))
                .map(Person::getName)
                .collect(Collectors.toList());
    }


    @Test
    public void sumVsReduceDemo() {
        int reduce = Stream.of(1, 2, 3, 4, 2).filter(o -> o % 2 != 0).reduce(Integer::sum).orElse(0);
        int sum = Stream.of(1, 2, 3, 4, 2).filter(o -> o % 2 != 0).mapToInt(s -> s).sum();
        System.out.println(reduce + " " + sum);
    }
}
