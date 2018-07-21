package com.example.project;

public class EmptyNameException extends RuntimeException {
    public EmptyNameException(){
        super("firstName or lastName is empty.");
    }
}
