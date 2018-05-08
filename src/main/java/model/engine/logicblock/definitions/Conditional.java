package model.engine.logicblock.definitions;

public interface Conditional<T> {

    boolean verify(T t);

    default void doPositive(T t) {}

    default void doNegative(T t) {}
}
