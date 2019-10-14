package dev.illescas.mastermind.utils;

public interface Originator {

    void restore(Memento memento);

    Memento createMemento();

}
