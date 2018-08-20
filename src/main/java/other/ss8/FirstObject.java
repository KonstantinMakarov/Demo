package other.ss8;

public class FirstObject extends MyObject {

    public FirstObject(String env, String type, String port, String protocol) {
        super(env, type, port, "run " + protocol, "header1");
    }
}
