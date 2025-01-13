package org.library.lms;


import java.util.*;
import java.util.Observer;

public class LibraryUser implements Observer {
    private String name;
    private String patronId;
    private List<String> borrowingHistory;

    public LibraryUser(String name, String patronId) {
        this.name = name;
        this.patronId = patronId;
        this.borrowingHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return patronId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPatronId() {
        return patronId;
    }
   

    public void borrowBook(LibraryBook libraryBook) {
        borrowingHistory.add(libraryBook.toString());
        libraryBook.setAvailable(false);
    }

    public void returnBook(LibraryBook libraryBook) {
        libraryBook.setAvailable(true);
    }

    public void displayBorrowingHistory() {
        System.out.println("Borrowing History of " + name + ": " + borrowingHistory);
    }


    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

