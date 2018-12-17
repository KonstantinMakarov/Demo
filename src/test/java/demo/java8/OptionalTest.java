package demo.java8;

import lombokentity.Person;
import lombokentity.address.Address;
import org.testng.annotations.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void nullCheckerOptional_personNull() {
        nullCheckerOptional(null);
    }

    @Test
    public void nullCheckerOptional_personWithNullAddress() {
        nullCheckerOptional(new Person("Bob", null));
    }

    @Test
    public void nullCheckerOptional_personWithNullInStreetAddress() {
        nullCheckerOptional(new Person("Bob", new Address(null, 10)));
    }

    @Test
    public void nullCheckerOptional_personWithoutAnyNull() {
        nullCheckerOptional(new Person("Bob", new Address("Bob Street", 10)));
    }

    private void nullCheckerOptional(Person person) {
        Optional.ofNullable(person)
                .map(Person::getAddress)
                .map(Address::getStreet)
                .ifPresent(System.out::println);
    }

}
