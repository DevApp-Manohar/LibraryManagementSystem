package org.library.lms;


import java.util.*;

public class BookAvailabilityManager implements EventPublisher {
    private List<NotificationListener> notificationListeners = new ArrayList<>();

    public void addObserver(NotificationListener notificationListener) {
        notificationListeners.add(notificationListener);
    }

    public void removeObserver(NotificationListener notificationListener) {
        notificationListeners.remove(notificationListener);
    }

    @Override
    public void addObserver(java.util.Observer observer) {

    }

    @Override
    public void removeObserver(java.util.Observer observer) {

    }

    public void notifyObservers(String message) {
        for (NotificationListener notificationListener : notificationListeners) {
            notificationListener.update(message);
        }
    }
}

