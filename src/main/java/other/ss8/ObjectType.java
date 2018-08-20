package other.ss8;

public enum ObjectType {

    FIRST(new FirstObjectBuilder());

    private ObjectBuilder objectBuilder;

    ObjectType(ObjectBuilder genericCF) {
        this.objectBuilder = genericCF;
    }

    public ObjectBuilder getObject() {
        return objectBuilder;
    }

}