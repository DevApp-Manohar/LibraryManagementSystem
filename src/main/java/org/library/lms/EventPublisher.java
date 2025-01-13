package org.library.lms;


import java.util.Observer;

public interface EventPublisher {
    void addObserver(java.util.Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

