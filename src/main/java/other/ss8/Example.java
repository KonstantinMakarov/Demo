package other.ss8;

public class Example {


    public static void main(String[] args) {
        Example ex = new Example();
        ex.suite("FIRST", "env", "type", "port", "protocol");
    }

    public void suite(String objectName, String ... parameters) {
        MyObject obj = ObjectType.valueOf(objectName).getObject().buildObject(parameters);
        obj.start();
    }
}
