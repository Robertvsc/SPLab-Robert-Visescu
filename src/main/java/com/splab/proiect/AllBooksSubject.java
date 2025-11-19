package com.splab.proiect;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject {

    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void add(Book book) {
        notifyObservers(book);
    }

    private void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}