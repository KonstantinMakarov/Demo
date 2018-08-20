package other.ss8;

public class FirstObjectBuilder implements ObjectBuilder {

    @Override
    public MyObject buildObject(String... parameters) {
        return new FirstObject(parameters[0], parameters[1], parameters[2], parameters[3]);
    }
}
