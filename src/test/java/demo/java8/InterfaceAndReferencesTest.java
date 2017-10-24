package demo.java8;

import multimple.inheritance.InterfaceA;
import multimple.inheritance.InterfaceB;
import multimple.inheritance.MultipleInheritance;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceAndReferencesTest {

    @Test
    void defaultAndStaticMethodsDemo() {
        MultipleInheritance demo = new MultipleInheritance();
        demo.multipleInheritanceSimpleMethod();
        demo.commonDefaultMethod();
        demo.defaultInterfaceMethodA();
        demo.defaultInterfaceMethodB();
//        demo.staticMethodInterfaceA();
        InterfaceA.staticMethodInterfaceA();
        InterfaceB.staticMethodInterfaceB();
    }

    @Test
    void methodReferencesDemo() {
        List<String> list = Stream.of("K", "g", "B").map(String::valueOf).collect(Collectors.toList());
        System.out.println(list);
    }

}
