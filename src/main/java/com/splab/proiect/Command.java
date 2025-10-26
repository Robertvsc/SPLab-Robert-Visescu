package com.splab.proiect;


public interface Command<T> {
    T execute();
}