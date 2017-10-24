package multimple.inheritance;

public interface InterfaceA {

    default void commonDefaultMethod() {
        System.out.println("commonDefaultMethodA");
    }

    default void defaultInterfaceMethodA() {
        System.out.println("defaultInterfaceMethodA");
    }

    static void staticMethodInterfaceA() {
        System.out.println("staticMethodInterfaceA");
    }
}
