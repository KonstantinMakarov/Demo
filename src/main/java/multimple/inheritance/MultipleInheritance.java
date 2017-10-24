package multimple.inheritance;

public class MultipleInheritance implements InterfaceA, InterfaceB {

    public void multipleInheritanceSimpleMethod() {
        System.out.println("MultipleInheritance");
    }

    //Demo: comment this method
    @Override
    public void commonDefaultMethod() {
        System.out.println("commonDefaultMethodOverride");
    }

//    Demo: uncomment this method
//    static void staticMethodInterfaceA() {
//        System.out.println("staticMethodInterfaceA");
//    }
}
