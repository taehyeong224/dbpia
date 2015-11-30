package koreatech.cse.domain.total;

import java.util.List;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Books {
    private List<Book> books;

    public Books() {
        this.books = null;
    }

    @Override
    public String toString() {
        return "Books{" +
                "books=" + books +
                '}';
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
