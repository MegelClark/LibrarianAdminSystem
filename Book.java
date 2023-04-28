package librarySystem;

public class Book {
    private String author;
    private String title;
    private int year;
    private int numCopies;
    
    // The constructor method Book() initializes the properties of a book object with values passed as arguments when the object is created.
    public Book(String title, String author, int year, int numCopies) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.numCopies = numCopies;
    }
    
    //The methods getAuthor(), getTitle(), getYear(), and getNumCopies() return the corresponding properties of a book object.

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getNumCopies() {
        return numCopies;
    }
    // The borrowBook() method checks if there are available copies of the book, and decrements the number of copies if there are any available. If there are no available copies, it prints a message to the console.
    public void borrowBook() {
        if (numCopies > 0) {
            numCopies--;
        } else {
            System.out.println("No copies available to borrow");
        }
    }
    //The returnBook() method increments the number of copies of the book.
    public void returnBook() {
        numCopies++;
    }
    //The toString() method returns a string representation of the book object with its properties in a formatted string.
    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ") - " + numCopies + " available copies";
    }
}

