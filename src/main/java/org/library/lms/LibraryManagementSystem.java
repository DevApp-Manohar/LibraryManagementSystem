package org.library.lms;


import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager();

        while (true) {
            System.out.println("\n ******Library Management System******");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. List Books");
            System.out.println("5. Add Patron");
            System.out.println("6. Checkout Book");
            System.out.println("7. Return Book");
            System.out.println("8. Update Books");
            System.out.println("9. Update Patron");
            System.out.println("10. Patron Borrow History");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title You want to submit: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book's author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN No of BOOK: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    LibraryBook newLibraryBook = BookCreator.createBook(title, author, isbn, year);
                    libraryManager.addBook(newLibraryBook);
                    break;
                case 2:
                    System.out.print("Enter ISBN of book to remove: ");
                    String removeIsbn = scanner.nextLine();
                    LibraryBook libraryBookToRemove = libraryManager.searchByIsbn(removeIsbn);
                    if (libraryBookToRemove != null) {
                        libraryManager.removeBook(libraryBookToRemove);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ISBN to search: ");
                    String searchIsbn = scanner.nextLine();
                    LibraryBook libraryBook = libraryManager.searchByIsbn(searchIsbn);
                    System.out.println(libraryBook != null ? libraryBook : "Book not found.");
                    break;
                case 4:
                    libraryManager.listBooks();
                    break;
                case 5:
                    System.out.print("Enter patron name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patron ID: ");
                    String patronId = scanner.nextLine();
                    libraryManager.addPatron(new LibraryUser(name, patronId));
                    break;
                case 6:
                    System.out.print("Enter patron ID: ");
                    String pId = scanner.nextLine();
                    System.out.print("Enter ISBN of book to checkout: ");
                    String checkoutIsbn = scanner.nextLine();
                    libraryManager.checkoutBook(pId, checkoutIsbn);
                    break;
                case 7:
                    System.out.print("Enter patron ID: ");
                    String returnId = scanner.nextLine();
                    System.out.print("Enter ISBN of book to return: ");
                    String returnIsbn = scanner.nextLine();
                    libraryManager.returnBook(returnId, returnIsbn);
                    break;
                case 8:
                    System.out.print("Enter ISBN of the book to update: ");
                    String updateIsbn = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new publication year: ");
                    int newYear = scanner.nextInt();
                    libraryManager.updateBookByIsbn(updateIsbn, newTitle, newAuthor, newYear);
                    break;
                case 9:
                    System.out.print("Enter Patron ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    libraryManager.updatePatronById(updateId, newName);
                    break;
                case 10:
                    System.out.print("Enter Patron ID to view history: ");
                    String historyId = scanner.nextLine();
                    libraryManager.displayPatronBorrowHistory(historyId);
                    break;
                case 11:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
