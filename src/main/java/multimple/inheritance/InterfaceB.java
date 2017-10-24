package multimple.inheritance;

public interface InterfaceB {

    default void commonDefaultMethod() {
        System.out.println("commonDefaultMethodB");
    }

    default void defaultInterfaceMethodB() {
        System.out.println("defaultInterfaceMethodB");
    }

    static void staticMethodInterfaceB() {
        System.out.println("staticMethodInterfaceB");
    }

}
