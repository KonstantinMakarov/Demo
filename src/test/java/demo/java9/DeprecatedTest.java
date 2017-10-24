package demo.java9;

import org.testng.annotations.Test;

public class DeprecatedTest {

    @SuppressWarnings(value = {"deprecation", "removal"})
    @Test
    public void deprecatedMethodDemo() {
        System.out.println(goodMethod());
        System.out.println(java8DeprecatedMethod());
        System.out.println(java9deprecatedMethod());
        System.out.println(java9deprecatedMethodForRemoval());
    }

    @Deprecated
    private String java8DeprecatedMethod() {
        return "Old Deprecated";
    }

    @Deprecated(since = "1.19")
    private String java9deprecatedMethod() {
        return "Deprecated";
    }

    @Deprecated(since = "1.19", forRemoval = true)
    private String java9deprecatedMethodForRemoval() {
        return "Deprecated, forRemoval";
    }

    private String goodMethod() {
        return "Good";
    }

}
