package functional.interfaces;

@FunctionalInterface
public interface TriFunction<T,U,O,R> {

    R apply(T t, U u, O o);
}
