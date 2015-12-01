package koreatech.cse.domain.total;

import java.util.List;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Books {
    private List<Book> book;

    public Books(List<Book> books) {
        this.book = books;
    }

    public Books() {
        this.book = null;
    }

    @Override
    public String toString() {
        return "Books{" +
                "books=" + book +
                '}';
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> books) {
        this.book = books;
    }
}
