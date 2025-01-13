package org.library.lms;


public class BookCreator {
    public static LibraryBook createBook(String title, String author, String isbn, int year) {
        return new LibraryBook(title, author, isbn, year);
    }
}

