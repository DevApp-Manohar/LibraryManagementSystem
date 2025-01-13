package org.library.lms;

import java.util.*;

public class LibraryManager {
    private List<LibraryBook> libraryBooks = new ArrayList<>();
    private List<LibraryUser> libraryUsers = new ArrayList<>();
    private Map<String, List<String>> borrowHistory = new HashMap<>();
    private Map<LibraryUser, List<LibraryBook>> borrowedBooks = new HashMap<>();


    // Add Book
    public void addBook(LibraryBook libraryBook) {
        libraryBooks.add(libraryBook);
        System.out.println("Book added successfully!");
    }

    // Remove Book
    public void removeBook(LibraryBook libraryBook) {
        libraryBooks.remove(libraryBook);
        System.out.println("Book removed successfully!");
    }

    // Search Book
    public LibraryBook searchByIsbn(String isbn) {
        return libraryBooks.stream()
                .filter(libraryBook -> libraryBook.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    // List Books
    public void listBooks() {
        if (libraryBooks.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            libraryBooks.forEach(System.out::println);
        }
    }

    // Add Patron
    public void addPatron(LibraryUser libraryUser) {
        if (getPatronById(libraryUser.getId()) != null) {
            System.out.println("Error: Patron with ID " + libraryUser.getId() + " already exists.");
            return;
        }
        libraryUsers.add(libraryUser);
        System.out.println("Patron added: " + libraryUser.getName());
    }
    public LibraryUser getPatronById(String id) {
        for (LibraryUser libraryUser : libraryUsers) {
            if (libraryUser.getId().equals(id)) {
                return libraryUser;
            }
        }
        return null;
    }

    // Checkout Book
    public void checkoutBook(String patronId, String isbn) {
        LibraryUser libraryUser = findPatronById(patronId);
        LibraryBook libraryBook = searchByIsbn(isbn);

        if (libraryUser == null) {
            System.out.println("Error: Patron with ID " + patronId + " not found.");
            return;
        }
        if (libraryBook == null) {
            System.out.println("Error: Book with ISBN " + isbn + " not found.");
            return;
        }
        if (!libraryBook.isAvailable()) {
            System.out.println("Book is already checked out.");
            return;
        }

        borrowedBooks.putIfAbsent(libraryUser, new ArrayList<>());
        borrowedBooks.get(libraryUser).add(libraryBook);
        libraryUser.borrowBook(libraryBook);
        libraryBook.setAvailable(false);

        borrowHistory.putIfAbsent(patronId, new ArrayList<>());
        borrowHistory.get(patronId).add(libraryBook.toString());

        System.out.println("Book checked out successfully!");
    }

    // Return Book
    public void returnBook(String patronId, String isbn) {
        LibraryUser libraryUser = findPatronById(patronId);
        LibraryBook libraryBook = searchByIsbn(isbn);

        if (libraryUser == null) {
            System.out.println("Patron not found.");
            return;
        }
        if (libraryBook == null) {
            System.out.println("Book not found.");
            return;
        }
        if (libraryBook.isAvailable()) {
            System.out.println("Book is already in the library.");
            return;
        }

        libraryUser.returnBook(libraryBook);
        libraryBook.setAvailable(true);
        System.out.println("Book returned successfully!");
    }


    public void updateBookByIsbn(String isbn, String newTitle, String newAuthor, int newYear) {
        LibraryBook libraryBook = searchByIsbn(isbn);
        if (libraryBook != null) {
            libraryBook.setTitle(newTitle);
            libraryBook.setAuthor(newAuthor);
            libraryBook.setPublicationYear(newYear);
            System.out.println("Book details updated successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void updatePatronById(String patronId, String newName) {
        LibraryUser libraryUser = findPatronById(patronId);
        if (libraryUser != null) {
            libraryUser.setName(newName);
            System.out.println("Patron details updated successfully!");
        } else {
            System.out.println("Patron not found.");
        }
    }

    public void displayPatronBorrowHistory(String patronId) {
        if (borrowHistory.containsKey(patronId)) {
            List<String> history = borrowHistory.get(patronId);
            if (history.isEmpty()) {
                System.out.println("No borrow history found for this patron.");
            } else {
                System.out.println("Borrow History for Patron ID " + patronId + ":");
                history.forEach(System.out::println);
            }
        } else {
            System.out.println("Patron not found.");
        }
    }

    // Find Patron
    private LibraryUser findPatronById(String patronId) {
        return libraryUsers.stream()
                .filter(libraryUser -> libraryUser.getId().equals(patronId))
                .findFirst()
                .orElse(null);
    }
}

