package koreatech.cse.domain.total;

import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Books {
    private List<Book> book;

    public Books(List<Book> books) {
        this.book = books;
    }

    public Books() {
        this.book = null;
    }

    public String toString() {
        return "Books{books=" + this.book + '}';
    }

    public List<Book> getBook() {
        return this.book;
    }

    public void setBook(List<Book> books) {
        this.book = books;
    }
}