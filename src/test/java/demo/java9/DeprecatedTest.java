package demo.java9;

import org.testng.annotations.Test;

public class DeprecatedTest {

    @Test
    public void deprecatedMethodDemo() {
        System.out.println(java8DeprecatedMethod());
//        System.out.println(java9deprecatedMethod());
//        System.out.println(java9deprecatedMethodForRemoval());
        System.out.println(goodMethod());
    }

    /**
     * Java 8 Deprecated Method
     *
     * @deprecated because of new java.
     *    Since 1.19 framework version
     *    Replaced by {@link #goodMethod()}
     */
    @Deprecated
    private String java8DeprecatedMethod() {
        return "Old Deprecated";
    }

//    @Deprecated(since = "1.19")
//    private String java9deprecatedMethod() {
//        return "Deprecated";
//    }
//
//    @Deprecated(forRemoval = true, since = "1.19")
//    private String java9deprecatedMethodForRemoval() {
//        return "Deprecated, forRemoval";
//    }

    private String goodMethod() {
        return "Good";
    }

}
